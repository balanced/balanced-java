package com.balancedpayments;

import java.util.Date;
import java.util.Map;

import com.balancedpayments.core.Resource;
import com.balancedpayments.core.ResourceCollection;
import com.balancedpayments.core.ResourceField;

import com.balancedpayments.errors.HTTPError;

public class Credit extends Resource {

    private static final String resource_href = "/bank_accounts";

    // fields

    @ResourceField(mutable=true)
    public Integer amount;

    @ResourceField(mutable=true)
    public String appears_on_statement_as;

    @ResourceField(mutable=true)
    public String description;

    @ResourceField(field="credits.order")
    public Order order;

    // attributes

    @ResourceField()
    public String currency;

    @ResourceField()
    public String failure_reason;

    @ResourceField()
    public String failure_reason_code;

    @ResourceField()
    public String status;

    @ResourceField()
    public String transaction_number;

    @ResourceField(field="credits.customer")
    public Customer customer;

    @ResourceField(field="credits.destination")
    public FundingInstrument destination;

    @ResourceField(field="credits.events")
    public Event.Collection events;

    @ResourceField(field="credits.reversals")
    public Reversal.Collection reversals;


    public static Credit get(String uri) throws HTTPError {
        return new Credit((Balanced.getInstance().getClient()).get(uri));
    }

    public Credit() {
        super();
    }

    public Credit(String uri) throws HTTPError {
        super(uri);
    }

    public Credit(Map<String, Object> payload) throws HTTPError {
        super(payload);
    }

    @Override
    public void save() throws HTTPError {
        if (id == null && href == null)
            href = resource_href;
        super.save();
    }

    public Reversal reverse(Map<String, Object> payload) throws HTTPError {
        return reversals.create(payload);
    }

    public Reversal reverse() throws HTTPError {
        return reverse(null);
    }

    public static class Collection extends ResourceCollection<Credit> {
        public Collection(String uri) {
            super(Credit.class, uri);
        }
    }
}
