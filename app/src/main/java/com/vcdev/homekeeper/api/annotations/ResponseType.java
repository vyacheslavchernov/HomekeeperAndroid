package com.vcdev.homekeeper.api.annotations;

import com.vcdev.homekeeper.api.utils.Constants;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Аннотация типа ответа
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface ResponseType {
    public Constants.REQUEST_TYPES value() default Constants.REQUEST_TYPES.HTML;
}
