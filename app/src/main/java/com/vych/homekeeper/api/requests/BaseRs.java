package com.vych.homekeeper.api.requests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vych.homekeeper.api.annotations.Name;
import com.vych.homekeeper.api.annotations.ResponseType;
import com.vych.homekeeper.api.utils.Constants;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Objects;

import okhttp3.Response;

/**
 * Базовая модель ответа для всех запросов к API
 */
@ResponseType(Constants.REQUEST_TYPES.HTML)
public class BaseRs {
    private String rawContent;

    public BaseRs parseResponse(Response response) {
        try {
            this.rawContent = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        HashMap<?, ?> result;
        try {
            result = new ObjectMapper().readValue(this.rawContent, HashMap.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        for (Field field : this.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(Name.class)) {
                field.setAccessible(true);

                try {
                    field.set(this, result.get(Objects.requireNonNull(field.getAnnotation(Name.class)).value()));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        return this;
    }
}
