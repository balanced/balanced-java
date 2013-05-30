package com.balancedpayments.core;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
public @interface ResourceField {

    public String field() default "";

    public boolean mutable() default false;

    public boolean required() default true;

    public boolean collection() default false;

}
