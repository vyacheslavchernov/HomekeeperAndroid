package com.vcdev.homekeeper.api.responses.authorization;

import com.vcdev.homekeeper.api.requests.BaseRs;

import okhttp3.Response;

/**
 * Модель ответа на запрос AuthRs
 */
public class AuthRs extends BaseRs {
    @Override
    protected boolean checkSuccess(Response response) {
        return response.request().url().toString().equals("https://homekeeper-vych.herokuapp.com/dashboard");
    }
}
