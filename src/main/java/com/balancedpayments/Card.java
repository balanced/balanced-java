package com.balancedpayments;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.balancedpayments.core.Client;
import com.balancedpayments.core.Resource;
import com.balancedpayments.core.ResourceCollection;
import com.balancedpayments.core.ResourceField;
import com.balancedpayments.errors.HTTPError;
import com.balancedpayments.errors.NotCreated;

public class Card extends Resource {

    @ResourceField()
    public Date created_at;

    @ResourceField(mutable=true)
    public Map<String, String> meta;

    @ResourceField(mutable=true)
    public String street_address;

    @ResourceField(mutable=true)
    public String postal_code;

    @ResourceField(mutable=true)
    public String country_code;

    @ResourceField(mutable=true)
    public String name;

    @ResourceField(mutable=true)
    public Integer expiration_month;

    @ResourceField(mutable=true)
    public Integer expiration_year;

    @ResourceField(field="last_four")
    public String card_number;

    @ResourceField()
    public String last_four;

    @ResourceField()
    public String brand;

    @ResourceField(mutable=true)
    public Boolean is_valid;

    @ResourceField(field="hash")
    public String fingerprint;

    @ResourceField(mutable=true, required=false)
    public String security_code;

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
            payload.put("security_code", security_code);
            return create(payload);
        }

        public Card create(
                String card_number,
                int expiration_month,
                int expiration_year) throws HTTPError {
            Map<String, Object> payload = new HashMap<String, Object>();
            payload.put("card_number", card_number);
            payload.put("expiration_month", expiration_month);
            payload.put("expiration_year", expiration_year);
            return create(payload);
        }
    };

    public static Card get(String uri) throws HTTPError {
        return new Card((new Client()).get(uri));
    }

    public Card() {
        super();
    }

    public Card(Map<String, Object> payload) {
        super(payload);
    }

    public Card(String uri) throws HTTPError {
        super(uri);
    }

    public void invalidate() throws HTTPError {
        is_valid = false;
        save();
    }

    public void unstore() throws HTTPError, NotCreated {
        super.delete();
    }

}
