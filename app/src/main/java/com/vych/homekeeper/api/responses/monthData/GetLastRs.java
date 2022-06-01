package com.vych.homekeeper.api.responses.monthData;

import com.vych.homekeeper.api.annotations.Name;
import com.vych.homekeeper.api.annotations.ResponseType;
import com.vych.homekeeper.api.requests.BaseRs;
import com.vych.homekeeper.api.utils.Constants;

import okhttp3.Response;

@ResponseType(Constants.REQUEST_TYPES.JSON)
public class GetLastRs extends BaseRs {
    @Name("id")
    private String id;

    @Name("year")
    private Integer year;

    @Name("month")
    private Integer month;

    @Name("hotwater")
    private Integer hotwater;

    @Name("coldwater")
    private Integer coldwater;

    @Name("electricity")
    private Integer electricity;

    @Name("rent")
    private Double rent;

    @Name("ethernet")
    private Double ethernet;

    @Name("peoples")
    private Integer peoples;

    public String getId() {
        return id;
    }

    public Integer getYear() {
        return year;
    }

    public Integer getMonth() {
        return month;
    }

    public Integer getHotwater() {
        return hotwater;
    }

    public Integer getColdwater() {
        return coldwater;
    }

    public Integer getElectricity() {
        return electricity;
    }

    public Double getRent() {
        return rent;
    }

    public Double getEthernet() {
        return ethernet;
    }

    public Integer getPeoples() {
        return peoples;
    }

    @Override
    protected boolean checkSuccess(Response response) {
        return response.isSuccessful();
    }
}
