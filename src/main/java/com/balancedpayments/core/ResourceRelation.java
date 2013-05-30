package com.balancedpayments.core;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
public @interface ResourceRelation {

    public String field();

}
