package com.balancedpayments;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.balancedpayments.core.Client;
import com.balancedpayments.core.Resource;
import com.balancedpayments.core.ResourceCollection;
import com.balancedpayments.core.ResourceField;
import com.balancedpayments.core.ResourceQuery;
import com.balancedpayments.errors.HTTPError;

public class BankAccount extends Resource {

    public final static String Checking = "checking";
    public final static String Savings = "savings";

    @ResourceField()
    public Date created_at;

    @ResourceField(mutable=true)
    public String name;

    @ResourceField(mutable=true)
    public String account_number;

    @ResourceField(mutable=true)
    public String routing_number;

    @ResourceField(mutable=true)
    public String type;

    @ResourceField()
    public String fingerprint;

    @ResourceField()
    public String bank_name;

    @ResourceField()
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

    @Deprecated
    @ResourceField(required=false)
    public Boolean is_valid;

    protected static final String root_uri = "/v" + Settings.VERSION + "/bank_accounts";

    public static class Collection extends ResourceCollection<BankAccount> {
        public Collection(String uri) {
            super(BankAccount.class, uri);
        }
    }

    /**
     * Returns a bank account object, given a URI for a bank account.
     *
     * @param uri The URI of a bank account you wish to instantiate
     * @return a bank account object
     * @throws HTTPError
     */
    public static BankAccount get(String uri) throws HTTPError {
        return new BankAccount((new Client()).get(uri));
    }

    /**
     * Constructor
     */
    public BankAccount() {
        super();
    }

    /**
     * Constructor
     *
     * @param uri The URI of a bank account you wish to instantiate
     * @throws HTTPError
     */
    public BankAccount(String uri) throws HTTPError {
        super(uri);
    }

    /**
     * Creates a new bank account using the contents of the payload.
     * @param payload See <a href="https://github.com/balanced/balanced-api/blob/master/resources/bank_accounts.rst#create-a-bank-account" target="_blank">Bank Account API Reference</a>
     *                for the required fields
     */
    public BankAccount(Map<String, Object> payload) {
        super(payload);
    }

    /**
     * Class method for querying for bank accounts based on the values
     * of their attributes.
     *
     * @return a Resource Query
     */
    public static ResourceQuery<BankAccount> query() {
        return new ResourceQuery<BankAccount>(BankAccount.class, root_uri);
    }

    /**
     * Persists changes to a local object instance by making an API call
     *
     * @throws HTTPError
     */
    @Override
    public void save() throws HTTPError {
        if (id == null && uri == null) {
            uri = root_uri;
        }
        super.save();
    }

    /**
     * Attempts to verify a bank account
     *
     * @return a BankAccountVerification object
     * @throws HTTPError
     */
    public BankAccountVerification verify() throws HTTPError {
        return verifications.create();
    }

    /**
     * Returns an associated BankAccountVerification object for the bank
     * account.
     *
     * @return a BankAccountVerification object
     * @throws HTTPError
     */
    public BankAccountVerification getVerification() throws HTTPError {
        if (verification_uri == null) {
            return null;
        }
        return new BankAccountVerification(verification_uri);
    }

    /**
     * Credits a bank account
     *
     * @param amount the amount to be credited
     * @param description a description of the transaction
     * @param destination_uri the destination of the credit
     * @param appears_on_statement_as the text that appears on the bank statement
     * @param meta metadata field for information about the transaction
     * @return
     * @throws HTTPError
     */

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

    /**
     * Credits a bank account
     *
     * @param amount the amount to be credited
     * @return a Credit object
     * @throws HTTPError
     */
    public Credit credit(int amount) throws HTTPError {
        return credit(amount, null, null, null, null);
    }
}
