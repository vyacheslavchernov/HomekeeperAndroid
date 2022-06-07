package com.vcdev.homekeeper.api.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Аннотация пути для выполнения запроса
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface URL {
    public String value() default "";
}
