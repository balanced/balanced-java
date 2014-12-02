package com.balancedpayments;

import com.balancedpayments.core.Resource;
import com.balancedpayments.core.ResourceCollection;
import com.balancedpayments.core.ResourceField;
import com.balancedpayments.errors.FundingInstrumentNotCreditable;
import com.balancedpayments.errors.HTTPError;

import java.util.Map;

public class Order extends Resource {

    public static final String resource_href = "/orders";

    // fields

    @ResourceField(mutable=true)
    public String description;

    @ResourceField(mutable=true)
    public Map<String, String> delivery_address;

    // attributes

    @ResourceField()
    public Integer amount;

    @ResourceField()
    public Integer amount_escrowed;

    @ResourceField()
    public String currency;

    @ResourceField(field="orders.buyers")
    public Customer.Collection buyers;

    @ResourceField(field="orders.credits")
    public Credit.Collection credits;

    @ResourceField(field="orders.debits")
    public Debit.Collection debits;

    @ResourceField(field="orders.merchant")
    public Customer merchant;

    @ResourceField(field="orders.refunds")
    public Refund.Collection refunds;

    @ResourceField(field="orders.reversals")
    public Reversal.Collection reversals;


    public static class Collection extends ResourceCollection<Order> {
        public Collection(String uri) {
            super(Order.class, uri);
        }

        @Override
        public Order create(Map<String, Object> payload) throws HTTPError {
            return super.create(payload);
        }
    };

    public Order() {
        super();
    }
    public Order(String uri) throws HTTPError {
        super(uri);
    }

    public Order(Map<String, Object> payload) throws HTTPError {
        super(payload);
    }

    public Debit debitFrom(FundingInstrument fi, Map<String, Object> options) throws HTTPError {
        options.put("order", this.href);
        return fi.debit(options);
    }

    public Credit creditTo(BankAccount ba, Map<String, Object> options) throws HTTPError {
        options.put("order", this.href);
        return ba.credit(options);
    }

    public Credit creditTo(Card card, Map<String, Object> options) throws HTTPError, FundingInstrumentNotCreditable {
        options.put("order", this.href);
        return card.credit(options);
    }
}
