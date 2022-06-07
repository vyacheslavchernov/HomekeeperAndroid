package com.vcdev.homekeeper.api.responses.monthData;

import com.vcdev.homekeeper.api.annotations.Name;
import com.vcdev.homekeeper.api.annotations.ResponseType;
import com.vcdev.homekeeper.api.requests.BaseRs;
import com.vcdev.homekeeper.api.utils.Constants;

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
