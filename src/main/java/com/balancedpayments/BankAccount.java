package com.balancedpayments;

import com.balancedpayments.core.Client;
import com.balancedpayments.core.ResourceCollection;
import com.balancedpayments.core.ResourceField;
import com.balancedpayments.core.ResourceQuery;
import com.balancedpayments.errors.HTTPError;
import com.balancedpayments.errors.NotCreated;

import java.util.HashMap;
import java.util.Map;


public class BankAccount extends FundingInstrument {

    public final static String Checking = "checking";
    public final static String Savings = "savings";

    @ResourceField()
    public String fingerprint;

    @ResourceField(mutable=true)
    public String name;

    @ResourceField(mutable=true)
    public String account_number;

    @ResourceField(mutable=true)
    public String routing_number;

    @ResourceField(mutable=true)
    public String type;

    @ResourceField()
    public String bank_name;

    @ResourceField(mutable = true)
    public Map<String, String> meta;

    @ResourceField(field="verifications_uri")
    public BankAccountVerification.Collection verifications;

    @ResourceField()
    public String verification_uri;

    @ResourceField(required=false)
    public BankAccountVerification verification;

    @ResourceField(field="credits_uri")
    public Credit.Collection credits;

    @ResourceField(field="debits_uri")
    public Debit.Collection debits;

    @ResourceField(field="holds_uri")
    public Hold.Collection holds;

    protected static final String root_uri = "/v" + Settings.VERSION + "/bank_accounts";

    public static class Collection extends ResourceCollection<BankAccount> {
        public Collection(String uri) {
            super(BankAccount.class, uri);
        }
    }

    public static BankAccount get(String uri) throws HTTPError {
        return new BankAccount((new Client()).get(uri));
    }

    public BankAccount() {
        super();
    }

    public BankAccount(String uri) throws HTTPError {
        super(uri);
    }

    public BankAccount(Map<String, Object> payload) {
        super(payload);
    }

    public static ResourceQuery<BankAccount> query() {
        return new ResourceQuery<BankAccount>(BankAccount.class, root_uri);
    }

    @Override
    public void save() throws HTTPError {
        if (id == null && uri == null) {
            uri = root_uri;
        }
        super.save();
    }

    public BankAccountVerification verify() throws HTTPError {
        return verifications.create();
    }

    public BankAccountVerification getVerification() throws HTTPError {
        if (verification_uri == null) {
            return null;
        }
        return new BankAccountVerification(verification_uri);
    }

    public Credit credit(
            int amount,
            String description,
            String destination_uri,
            String appears_on_statement_as,
            Map<String, String> meta) throws HTTPError {
        Map<String, Object> payload = new HashMap<String, Object>();
        payload.put("amount", amount);
        if (description != null)
            payload.put("description", description);
        if (destination_uri != null)
            payload.put("destination", destination_uri);
        if (appears_on_statement_as != null)
            payload.put("appears_on_statement_as", appears_on_statement_as);
        if (meta != null)
            payload.put("meta", meta);
        return credits.create(payload);
    }

    public Credit credit(int amount) throws HTTPError {
        return credit(amount, null, null, null, null);
    }

    public void unstore() throws HTTPError, NotCreated {
        super.delete();
    }
}
