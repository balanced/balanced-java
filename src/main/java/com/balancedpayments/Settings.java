package com.balancedpayments;

public class Settings {

    public static final String VERSION = "1";
    public static String location = "https://api.balancedpayments.com";
    public static String key; 
    
    public static void configure(String location, String key) {
        Settings.location = location;
        Settings.location = key;
    }
}
