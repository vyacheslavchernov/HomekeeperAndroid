package com.vych.homekeeper.api.requests.montData;

import com.vych.homekeeper.api.annotations.RequestMethod;
import com.vych.homekeeper.api.annotations.URL;
import com.vych.homekeeper.api.requests.BaseRq;
import com.vych.homekeeper.api.responses.monthData.GetLastRs;
import com.vych.homekeeper.api.utils.Constants;

@URL("https://homekeeper-vych.herokuapp.com/api/monthdata/getlast")
@RequestMethod(Constants.REQUEST_METHOD.GET)
public class GetLastRq extends BaseRq {
    public GetLastRs post() {
        return (GetLastRs) this.postAs(GetLastRs.class);
    }
}
