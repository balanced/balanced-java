package com.balancedpayments;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.balancedpayments.core.ResourceCollection;
import com.balancedpayments.core.ResourceField;
import com.balancedpayments.core.ResourceQuery;
import com.balancedpayments.errors.HTTPError;
import com.balancedpayments.errors.NotCreated;
import com.google.gson.internal.StringMap;


public class BankAccount extends FundingInstrument {

    public static final String resource_href = "/bank_accounts";
    public final static String ACCOUNT_TYPE_CHECKING = "checking";
    public final static String ACCOUNT_TYPE_SAVINGS = "savings";

    // fields
    @ResourceField(mutable=true)
    public String account_type;

    @ResourceField(mutable=true)
    public String account_number;

    @ResourceField(mutable=true)
    public StringMap<String> address;

    @ResourceField(mutable=true)
    public String name;

    @ResourceField(mutable=true)
    public String routing_number;

    // attributes

    @ResourceField()
    public String bank_name;

    @ResourceField()
    public Boolean can_credit;

    @ResourceField()
    public Boolean can_debit;

    @ResourceField()
    public String fingerprint;

    @ResourceField(field="bank_accounts.bank_account_verifications")
    public BankAccountVerification.Collection verifications;

    @ResourceField(field="bank_accounts.bank_account_verification")
    public BankAccountVerification verification;

    @ResourceField(field="bank_accounts.credits")
    public Credit.Collection credits;

    @ResourceField(field="bank_accounts.debits")
    public Debit.Collection debits;

    public static class Collection extends ResourceCollection<BankAccount> {
        public Collection(String uri) {
            super(BankAccount.class, uri);
        }
    }

    public BankAccount() {
        super();
    }

    public BankAccount(String uri) throws HTTPError {
        super(uri);
    }

    public BankAccount(Map<String, Object> payload) throws HTTPError {
        super(payload);
    }

    public static ResourceQuery<BankAccount> query() {
        return new ResourceQuery<BankAccount>(BankAccount.class, resource_href);
    }

    @Override
    public void save() throws HTTPError {
        if (id == null && href == null) {
            href = resource_href;
        }
        super.save();
    }

    public BankAccountVerification verify() throws HTTPError {
        return verifications.create();
    }

    public Credit credit(Map<String, Object> payload) throws HTTPError {
        return credits.create(payload);
    }

    public Debit debit(Map<String, Object> payload) throws HTTPError {
        return debits.create(payload);
    }
}
