package com.vych.homekeeper.api.responses.monthData;

import com.vych.homekeeper.api.annotations.Name;
import com.vych.homekeeper.api.annotations.ResponseType;
import com.vych.homekeeper.api.requests.BaseRs;
import com.vych.homekeeper.api.utils.Constants;

import okhttp3.Response;

@ResponseType(Constants.REQUEST_TYPES.JSON)
public class GetCalcRs extends BaseRs {
    @Name("hotwater")
    private Double hotwater;

    @Name("coldwater")
    private Double coldwater;

    @Name("electricity")
    private Double electricity;

    @Name("drainage")
    private Double drainage;

    public Double getHotwater() {
        return hotwater;
    }

    public Double getColdwater() {
        return coldwater;
    }

    public Double getElectricity() {
        return electricity;
    }

    public Double getDrainage() {
        return drainage;
    }

    @Override
    protected boolean checkSuccess(Response response) {
        return response.isSuccessful();
    }
}
