package com.balancedpayments;

import java.util.Map;

import com.balancedpayments.core.Resource;
import com.balancedpayments.core.ResourceCollection;
import com.balancedpayments.core.ResourceField;
import com.balancedpayments.core.ResourceQuery;
import com.balancedpayments.errors.HTTPError;

public class Customer extends Resource {

    private static final String resource_href = "/customers";

    // fields

    @ResourceField(mutable=true)
    public Map<String, String> address;

    @ResourceField(mutable=true)
    public String business_name;

    @ResourceField(mutable=true)
    public Integer dob_month;

    @ResourceField(mutable=true)
    public Integer dob_year;

    @ResourceField(mutable=true)
    public String ein;

    @ResourceField(mutable=true)
    public String name;

    @ResourceField(mutable=true)
    public String phone;

    @ResourceField(mutable=true)
    public String ssn_last4;

    // attributes

    @ResourceField()
    public String merchant_status;

    @ResourceField(field="customers.bank_accounts")
    public BankAccount.Collection bank_accounts;

    //@ResourceField(field="customers.card_holds")
    //public CardHold.Collection card_holds;

    @ResourceField(field="customers.cards")
    public Card.Collection cards;

    @ResourceField(field="customers.credits")
    public Credit.Collection credits;

    @ResourceField(field="customers.debits")
    public Debit.Collection debits;

    //@ResourceField(field="customers.external_accounts")
    //public ExternalAccount.Collection external_accounts;

    @ResourceField(field="customers.orders")
    public Order.Collection orders;

    @ResourceField(field="customers.refunds")
    public Refund.Collection refunds;

    @ResourceField(field="customers.reversals")
    public Reversal.Collection reversals;


    public static class Collection extends ResourceCollection<Customer> {
        public Collection(String href) {
            super(Customer.class, href);
        }
    };

    public static ResourceQuery<Customer> query() {
        return new ResourceQuery<Customer>(
                Customer.class, resource_href);
    }

    public static Customer get(String href) throws HTTPError {
        return new Customer((Balanced.getInstance().getClient()).get(href));
    }

    public Customer() {
        super();
    }

    public Customer(String href) throws HTTPError {
        super(href);
    }

    public Customer(Map<String, Object> payload) throws HTTPError {
        super(payload);
    }

    public Order createOrder(Map<String, Object> payload) throws HTTPError {
        return orders.create(payload);
    }

    @Override
    public void save() throws HTTPError {
        if (id == null && href == null)
            href = resource_href;
        super.save();
    }
}
