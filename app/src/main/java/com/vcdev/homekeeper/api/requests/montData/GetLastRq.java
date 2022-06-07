package com.vcdev.homekeeper.api.requests.montData;

import android.content.Context;

import com.vcdev.homekeeper.activityes.LoadingActivity;
import com.vcdev.homekeeper.api.annotations.RequestMethod;
import com.vcdev.homekeeper.api.annotations.URL;
import com.vcdev.homekeeper.api.requests.BaseRq;
import com.vcdev.homekeeper.api.responses.monthData.GetLastRs;
import com.vcdev.homekeeper.api.utils.Constants;

@URL("https://homekeeper-vych.herokuapp.com/api/monthdata/getlast")
@RequestMethod(Constants.REQUEST_METHOD.GET)
public class GetLastRq extends BaseRq {
    public GetLastRs post() {
        return (GetLastRs) this.postAs(GetLastRs.class);
    }
}
