package com.vych.homekeeper.api.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Аннотация поля модели запроса\ответа
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Name {
    public String value() default "";
}
