package com.balanced;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.balanced.core.Resource;
import com.balanced.core.ResourceCollection;
import com.balanced.core.ResourceQuery;
import com.balanced.errors.HTTPError;
import com.balanced.errors.MultipleResultsFound;
import com.balanced.errors.NoResultsFound;

public class Merchant extends Resource {
    
    public static final String PERSON_TYPE = "person";
    public static final String BUSINESS_TYPE = "business";
    
    public Date created_at;
    public String type;
    public String name;
    public String email_address;
    public String phone_number;
    public String accounts_uri;
    public ResourceCollection<Account> accounts;
    public String api_keys_uri;
    public ResourceCollection<APIKey> api_keys;
    public String street_address;
    public String city;
    public String postal_code;
    public String country_code;
    public Map<String, String> meta;
    
    
    public static ResourceQuery<Merchant> query() {
        return new ResourceQuery<Merchant>(
                Merchant.class,
                String.format("/v%s/%s", Settings.VERSION, "merchants"));
    }
    
    public static Merchant me() throws NoResultsFound, MultipleResultsFound, HTTPError {
        return query().one();
    }
    
    @Override
    public Map<String, Object> serialize() {
        Map<String, Object> payload = new HashMap<String, Object>();
        payload.put("type", type);
        payload.put("name", name);
        payload.put("email_address", email_address);
        payload.put("phone_number", phone_number);
        payload.put("accounts_uri", accounts_uri);
        payload.put("street_address", street_address);
        payload.put("city", city);
        payload.put("postal_code", postal_code);
        payload.put("country_code", country_code);
        payload.put("meta", meta);
        return payload;
    }

    @Override
    public void deserialize(Map<String, Object> payload) {
        super.deserialize(payload);
        created_at = deserializeDate((String) payload.get("created_at"));
        meta = (Map<String, String>) payload.get("meta");
        type = (String) payload.get("type");
        name = (String) payload.get("name");
        email_address = (String) payload.get("email_address");
        phone_number = (String) payload.get("phone_number");
        street_address = (String) payload.get("street_address");
        city = (String) payload.get("city");
        postal_code = (String) payload.get("postal_code");
        country_code = (String) payload.get("country_code");        
        accounts_uri = (String) payload.get("accounts_uri");
        accounts = new ResourceCollection<Account>(Account.class, accounts_uri);
        api_keys_uri = (String) payload.get("api_keys_uri");
        api_keys = new ResourceCollection<APIKey>(APIKey.class, api_keys_uri);
    }
}
