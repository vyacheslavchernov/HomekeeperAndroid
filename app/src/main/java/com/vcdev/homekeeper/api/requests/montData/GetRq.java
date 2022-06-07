package com.vcdev.homekeeper.api.requests.montData;

import com.vcdev.homekeeper.api.annotations.Name;
import com.vcdev.homekeeper.api.annotations.RequestMethod;
import com.vcdev.homekeeper.api.annotations.URL;
import com.vcdev.homekeeper.api.requests.BaseRq;
import com.vcdev.homekeeper.api.responses.monthData.GetRs;
import com.vcdev.homekeeper.api.utils.Constants;

/**
 * Модель запроса информации о месяце по ID
 */
@URL("https://homekeeper-vych.herokuapp.com/api/monthdata/get")
@RequestMethod(Constants.REQUEST_METHOD.GET)
public class GetRq extends BaseRq {

    @Name("id")
    private String id;

    public GetRq setId(String id) {
        this.id = id;
        return this;
    }

    public GetRs post() {
        return (GetRs) postAs(GetRs.class);
    }
}
