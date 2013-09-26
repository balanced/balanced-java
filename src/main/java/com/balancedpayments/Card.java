package com.balancedpayments;

import java.util.HashMap;
import java.util.Map;

import com.balancedpayments.core.ResourceCollection;
import com.balancedpayments.core.ResourceField;
import com.balancedpayments.errors.HTTPError;
import com.balancedpayments.errors.NotCreated;

public class Card extends FundingInstrument {

    @ResourceField(field="hash")
    public String fingerprint;

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
    public String card_type;

    @ResourceField()
    public String brand;

    @ResourceField()
    public Boolean is_valid;

    @ResourceField()
    public Boolean is_verified;

    @ResourceField()
    public String postal_code_check;

    @ResourceField(mutable=true, required=false)
    public String security_code;

    @ResourceField()
    public String security_code_check;

    @ResourceField(required=false)
    public String customer_uri;

    @ResourceField(field="customer_uri", required=false)
    public Customer customer;

    public static class Collection extends ResourceCollection<Card> {
        public Collection(String uri) {
            super(Card.class, uri);
        }

        public Card create(Map<String, Object> payload) throws HTTPError {
            return super.create(payload);
        }
    };

    public static Card get(String uri) throws HTTPError {
        return new Card((Balanced.getInstance().getClient()).get(uri));
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
}
