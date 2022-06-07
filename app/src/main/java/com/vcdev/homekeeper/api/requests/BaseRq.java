package com.vcdev.homekeeper.api.requests;

import com.vcdev.homekeeper.api.Connection;
import com.vcdev.homekeeper.api.annotations.Name;
import com.vcdev.homekeeper.api.annotations.RequestMethod;
import com.vcdev.homekeeper.api.annotations.URL;
import com.vcdev.homekeeper.api.utils.Constants;
import com.vcdev.homekeeper.api.utils.Constants.REQUEST_METHOD;


import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;



/**
 * Базовая модель для всех запросов к API
 */
public abstract class BaseRq {
    private String url;
    private REQUEST_METHOD requestMethod;
    private final HashMap<String, String> parameters;
    private Response response = null;

    private final Class<?> clazz;

    public BaseRq() {
        this.parameters = new HashMap<>();

        // Получение данных о запросе из аннотаций модели
        this.clazz = this.getClass();
        setUrl(Objects.requireNonNull(this.clazz.getAnnotation(URL.class)).value());
        setRequestMethod(Objects.requireNonNull(this.clazz.getAnnotation(RequestMethod.class)).value());
    }

    /**
     * Создание тела запроса из параметров. (Используется только для POST)
     *
     * @return RequestBody содержащий параметры из this.parameters
     */
    private RequestBody fillBody() {
        FormBody.Builder builder = new FormBody.Builder();
        Set<String> keys = this.parameters.keySet();

        for (String key : keys) {
            builder.add(key, Objects.requireNonNull(this.parameters.get(key)));
        }

        return builder.build();
    }

    /**
     * Заполняет this.parameters значениями из полей модели запроса помеченных аннотацией Name
     * (Используется только для POST)
     *
     */
    void fillParameters() throws IllegalAccessException {
        for (Field field : this.clazz.getDeclaredFields()) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(Name.class)) {
                field.setAccessible(true);
                this.parameters.put(
                        Objects.requireNonNull(field.getAnnotation(Name.class)).value(),
                        (String) field.get(this)
                );
            }
        }
    }

    private void setUrl(String value) {
        this.url = value;
    }

    private void setRequestMethod(Constants.REQUEST_METHOD value) {
        this.requestMethod = value;
    }

    /**
     * Создание объекта запроса
     *
     * @param requestBody тело создаваемого запроса
     * @return Request
     */
    private Request buildRequest(RequestBody requestBody) {
        switch (this.requestMethod) {
            case GET:
                if (!this.parameters.isEmpty()) {
                    HttpUrl.Builder urlBuilder = Objects.requireNonNull(HttpUrl.parse(url)).newBuilder();
                    for (Map.Entry<String, String> param : this.parameters.entrySet()) {
                        urlBuilder.addQueryParameter(param.getKey(), param.getValue());
                    }
                    return new Request.Builder()
                            .url(urlBuilder.build())
                            .build();
                } else {
                    return new Request.Builder()
                            .url(this.url)
                            .build();
                }

            case POST:
                return new Request.Builder()
                        .url(this.url)
                        .post(requestBody)
                        .build();
        }

        return null;
    }

    public abstract BaseRs post();

    /**
     * Собирает и отправляет запрос на основе модели.
     *
     * @param responseModel модель ответа на запрос
     * @return Объект ответа на запрос в соответсвии с переданной моделью
     */
    protected BaseRs postAs(Class<? extends BaseRs> responseModel) {
        try {
            fillParameters();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }

        RequestBody requestBody = this.requestMethod == REQUEST_METHOD.POST ? fillBody() : null;
        Request request = buildRequest(requestBody);

        assert request != null;
        try {
            response = Connection.client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (response == null) {
            return null;
        }

        BaseRs rs = null;
        try {
            rs = responseModel.newInstance();
            rs.parseResponse(response);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rs;
    }
}
