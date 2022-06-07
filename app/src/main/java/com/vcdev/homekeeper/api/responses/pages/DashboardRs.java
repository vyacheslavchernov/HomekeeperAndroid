package com.vcdev.homekeeper.api.responses.pages;

import com.vcdev.homekeeper.api.annotations.ResponseType;
import com.vcdev.homekeeper.api.requests.BaseRs;
import com.vcdev.homekeeper.api.utils.Constants;

import okhttp3.Response;

@ResponseType(Constants.REQUEST_TYPES.HTML)
public class DashboardRs extends BaseRs {
    @Override
    protected boolean checkSuccess(Response response) {
        return !response.request().url().toString().equals("https://homekeeper-vych.herokuapp.com/login");
    }
}
