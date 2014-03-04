package com.balancedpayments;

import java.util.Map;

import com.balancedpayments.core.ResourceCollection;
import com.balancedpayments.core.ResourceField;
import com.balancedpayments.core.ResourceQuery;
import com.balancedpayments.errors.HTTPError;

public class Card extends FundingInstrument {

    private static final String resource_href = "/cards";

    // fields
    @ResourceField(mutable=true)
    public Map<String, String> address;

    @ResourceField(mutable=true, required=false)
    public String cvv;

    @ResourceField(mutable=true, required=true)
    public Integer expiration_month;

    @ResourceField(mutable=true, required=true)
    public Integer expiration_year;

    @ResourceField(mutable=true)
    public String name;

    @ResourceField(mutable=true, required=true)
    public String number;

    // attributes

    @ResourceField()
    public String avs_postal_match;

    @ResourceField()
    public String avs_result;

    @ResourceField()
    public String avs_street_match;

    @ResourceField()
    public String brand;

    @ResourceField()
    public String cvv_match;

    @ResourceField()
    public String cvv_result;

    @ResourceField()
    public String fingerprint;

    @ResourceField()
    public Boolean is_verified;

    @ResourceField(field="cards.card_holds")
    public CardHold.Collection card_holds;

    @ResourceField(field="cards.customer")
    public Customer customer;

    @ResourceField(field="cards.debits")
    public Debit.Collection debits;


    public static class Collection extends ResourceCollection<Card> {
        public Collection(String uri) {
            super(Card.class, uri);
        }

        @Override
        public Card create(Map<String, Object> payload) throws HTTPError {
            return super.create(payload);
        }
    }

    public Card() {
        super();
    }

    public Card(Map<String, Object> payload) throws HTTPError {
        super(payload);
    }

    public Card(String uri) throws HTTPError {
        super(uri);
    }

    public static ResourceQuery<Card> query() {
        return new ResourceQuery<Card>(Card.class, resource_href);
    }

    @Override
    public void save() throws HTTPError {
        if (id == null && href == null)
            href = resource_href;
        super.save();
    }

    public CardHold hold(Map<String, Object> payload) throws HTTPError {
        return card_holds.create(payload);
    }

    @Override
    public Debit debit(Map<String, Object> payload) throws HTTPError {
        return debits.create(payload);
    }
}
