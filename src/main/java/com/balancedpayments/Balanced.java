package com.balancedpayments;

import com.balancedpayments.core.Client;

public class Balanced {

    private static final Balanced _instance = new Balanced();

    private static final String API_VERSION = "1";
    private static final String API_URL = "https://api.balancedpayments.com";
    private String KEY;
    private Client client = new Client(API_URL, null);

    private Balanced() {}

    public static synchronized Balanced getInstance() {
        return _instance;
    }

    public void configureClient(String key) {
        KEY=key;
        client = new Client(API_URL, key);
    }
    public static void configure(String key) {
        getInstance().configureClient(key);
    }

    public Client getClient() {
        return client;
    }

    public String getAPIVersion() {
        return API_VERSION;
    }

    public String getAPIURL() {
        return API_URL;
    }
}
