package com.balancedpayments.core;

public class Utils {
    public static String classNameToResourceKey(String name) {
        return name.replaceAll("\\B([A-Z])", "_$1").toLowerCase() + "s";
    }
}
