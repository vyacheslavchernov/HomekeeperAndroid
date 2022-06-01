package com.vych.homekeeper.api.requests.montData;

import com.vych.homekeeper.api.annotations.Name;
import com.vych.homekeeper.api.annotations.RequestMethod;
import com.vych.homekeeper.api.annotations.URL;
import com.vych.homekeeper.api.requests.BaseRq;
import com.vych.homekeeper.api.responses.monthData.GetCalcRs;
import com.vych.homekeeper.api.utils.Constants;

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
