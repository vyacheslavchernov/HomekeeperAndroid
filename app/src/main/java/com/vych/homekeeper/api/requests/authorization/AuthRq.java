package com.vych.homekeeper.api.requests.authorization;

import com.vych.homekeeper.api.annotations.Name;
import com.vych.homekeeper.api.annotations.RequestMethod;
import com.vych.homekeeper.api.annotations.URL;
import com.vych.homekeeper.api.requests.BaseRq;
import com.vych.homekeeper.api.requests.BaseRs;
import com.vych.homekeeper.api.responses.authorization.AuthRs;
import com.vych.homekeeper.api.utils.Constants;

/**
 * Модель запроса авторизации
 */
@URL("https://homekeeper-vych.herokuapp.com/perform-login")
@RequestMethod(Constants.REQUEST_METHOD.POST)
public class AuthRq extends BaseRq {

    @Name("user")
    private String user;

    @Name("pass")
    private String pass;

    public AuthRq setUser(String value) {
        this.user = value;
        return this;
    }

    public AuthRq setPassword(String value) {
        this.pass = value;
        return this;
    }

    public AuthRs post() {
        return (AuthRs) this.postAs(AuthRs.class);
    }
}
