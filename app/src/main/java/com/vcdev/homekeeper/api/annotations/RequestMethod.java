package com.vcdev.homekeeper.api.annotations;

import com.vcdev.homekeeper.api.utils.Constants;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Аннотация типа запроса
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface RequestMethod {
    public Constants.REQUEST_METHOD value() default Constants.REQUEST_METHOD.POST;
}
