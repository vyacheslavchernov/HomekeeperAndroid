package com.vcdev.homekeeper.api.requests.montData;

import com.vcdev.homekeeper.api.annotations.Name;
import com.vcdev.homekeeper.api.annotations.RequestMethod;
import com.vcdev.homekeeper.api.annotations.URL;
import com.vcdev.homekeeper.api.requests.BaseRq;
import com.vcdev.homekeeper.api.responses.monthData.GetCalcRs;
import com.vcdev.homekeeper.api.utils.Constants;

@URL("https://homekeeper-vych.herokuapp.com/api/monthdata/getCalc")
@RequestMethod(Constants.REQUEST_METHOD.GET)
public class GetCalcRq extends BaseRq {
    @Name("id")
    private String id;

    public GetCalcRq setId(String id) {
        this.id = id;
        return this;
    }

    public GetCalcRs post() {
        return (GetCalcRs) postAs(GetCalcRs.class);
    }
}
