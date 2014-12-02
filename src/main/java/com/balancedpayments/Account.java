package com.balancedpayments;

import com.balancedpayments.core.ResourceCollection;
import com.balancedpayments.core.ResourceField;
import com.balancedpayments.core.ResourceQuery;
import com.balancedpayments.errors.HTTPError;

import java.util.Map;

public class Account extends FundingInstrument {

    public static final String resource_href = "/accounts";

    // fields
    @ResourceField(mutable = true)
    public String description;

    // attributes

    @ResourceField()
    public String account_type;

    @ResourceField()
    public Boolean can_credit;

    @ResourceField()
    public Boolean can_debit;

    @ResourceField()
    public String currency;

    @ResourceField()
    public Integer balance;

    @ResourceField(field = "accounts.customer")
    public Customer customer;

    @ResourceField(field = "accounts.settlements")
    public Settlement.Collection settlements;

    @ResourceField(field = "accounts.credits")
    public Credit.Collection credits;

    @ResourceField(field = "accounts.debits")
    public Debit.Collection debits;

    public static class Collection extends ResourceCollection<Account> {
        public Collection(String uri) {
            super(Account.class, uri);
        }
    }

    public Account() {
        super();
    }

    public Account(String uri) throws HTTPError {
        super(uri);
    }

    public Account(Map<String, Object> payload) throws HTTPError {
        super(payload);
    }

    public static ResourceQuery<Account> query() {
        return new ResourceQuery<Account>(Account.class, resource_href);
    }

    @Override
    public Credit credit(Map<String, Object> payload) throws HTTPError {
        return credits.create(payload);
    }

    @Override
    public void save() throws HTTPError {
        if (id == null && href == null)
            href = resource_href;
        super.save();
    }

    public Settlement settle(Map<String, Object> payload) throws HTTPError {
        return settlements.create(payload);
    }
}