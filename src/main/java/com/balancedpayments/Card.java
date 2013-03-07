package com.balancedpayments;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.balancedpayments.core.Client;
import com.balancedpayments.core.Resource;
import com.balancedpayments.core.ResourceCollection;
import com.balancedpayments.errors.HTTPError;

public class Card extends Resource {
    
    public Date created_at;
    public Map<String, String> meta;
    public String street_address;
    public String postal_code;
    public String country_code;
    public String name;
    public Integer expiration_month;
    public Integer expiration_year;
    public String card_number;
    public String last_four;
    public String brand;
    public Boolean is_valid;
    public String fingerprint;
    
    public static class Collection extends ResourceCollection<Card> {
        public Collection(String uri) {
            super(Card.class, uri);
        }
        
        public Card create(
                String street_address,
                String city,
                String region,
                String postal_code,
                String name,
                String card_number,
                String security_code,
                int expiration_month,
                int expiration_year) throws HTTPError {
            Map<String, Object> payload = new HashMap<String, Object>();
            payload.put("street_address", street_address);
            payload.put("city", city);
            payload.put("region", region);
            payload.put("postal_code", postal_code);
            payload.put("name", name);
            payload.put("card_number", card_number);
            payload.put("expiration_month", expiration_month);
            payload.put("expiration_year", expiration_year);
            return create(payload);
        }
    };
    
    public Card() {
        super();
    }
    
    public Card(Map<String, Object> payload) {
        super(payload);
    }
    
    public Card(String uri) throws HTTPError {
        super(uri);
    }
    
    @Override
    public Map<String, Object> serialize() {
        Map<String, Object> payload = new HashMap<String, Object>();
        payload.put("meta", meta);
        payload.put("card_number", card_number);
        payload.put("street_address", street_address);
        payload.put("postal_code", postal_code);
        payload.put("country_code", country_code);
        payload.put("name", name);
        payload.put("expiration_month", expiration_month);
        payload.put("expiration_year", expiration_year);
        payload.put("is_valid", is_valid);
        return payload;
    }

    @Override
    public void deserialize(Map<String, Object> payload) {
        super.deserialize(payload);
        created_at = deserializeDate((String) payload.get("created_at"));
        meta = (Map<String, String>) payload.get("meta");
        street_address = (String) payload.get("street_address");
        postal_code = (String) payload.get("postal_code");
        country_code = (String) payload.get("country_code");
        name = (String) payload.get("name");
        expiration_month = ((Double) payload.get("expiration_month")).intValue();
        expiration_year = ((Double) payload.get("expiration_year")).intValue();
        card_number = (String) payload.get("last_four");
        last_four = (String) payload.get("last_four");
        brand = (String) payload.get("brand");
        is_valid = (Boolean) payload.get("is_valid");
        fingerprint = (String) payload.get("hash");
    }
}
