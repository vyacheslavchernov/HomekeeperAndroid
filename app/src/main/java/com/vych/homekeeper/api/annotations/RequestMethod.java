package com.vych.homekeeper.api.annotations;

import com.vych.homekeeper.api.utils.Constants;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Аннотация типа запроса
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface RequestMethod {
    public Constants.REQUEST_METHOD value() default Constants.REQUEST_METHOD.POST;
}
