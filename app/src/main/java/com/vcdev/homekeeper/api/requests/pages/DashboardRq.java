package com.vcdev.homekeeper.api.requests.pages;

import com.vcdev.homekeeper.api.annotations.RequestMethod;
import com.vcdev.homekeeper.api.annotations.URL;
import com.vcdev.homekeeper.api.requests.BaseRq;
import com.vcdev.homekeeper.api.requests.BaseRs;
import com.vcdev.homekeeper.api.responses.pages.DashboardRs;
import com.vcdev.homekeeper.api.utils.Constants;

@URL("https://homekeeper-vych.herokuapp.com/dashboard")
@RequestMethod(Constants.REQUEST_METHOD.GET)
public class DashboardRq extends BaseRq {
    @Override
    public BaseRs post() {
        return (DashboardRs) postAs(DashboardRs.class);
    }
}
