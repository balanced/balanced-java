package com.balancedpayments;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.balancedpayments.core.Client;
import com.balancedpayments.core.Resource;
import com.balancedpayments.core.ResourceCollection;
import com.balancedpayments.core.ResourceField;
import com.balancedpayments.errors.HTTPError;

public class Account extends Resource {

    public static final String BUYER_ROLE = "buyer";
    public static final String MERCHANT_ROLE = "merchant";

    @ResourceField()
    public Date created_at;

    @ResourceField(mutable=true)
    public String name;

    @ResourceField(mutable=true)
    public String email_address;

    @ResourceField()
    public String roles[];

    @ResourceField(mutable=true)
    public Map<String, String> meta;

    @ResourceField(field="bank_accounts_uri")
    public BankAccount.Collection bank_accounts;

    @ResourceField(field="cards_uri")
    public Card.Collection cards;

    @ResourceField(field="credits_uri")
    public Credit.Collection credits;

    @ResourceField(field="debits_uri")
    public Debit.Collection debits;

    @ResourceField(field="holds_uri")
    public Hold.Collection holds;

    @ResourceField(field="refunds_uri")
    public Refund.Collection refunds;

    public static class Collection extends ResourceCollection<Account> {
        public Collection(String uri) {
            super(Account.class, uri);
        }
    };

    public static Account get(String uri) throws HTTPError {
        return new Account((new Client()).get(uri));
    }

    public Account() {
        super();
    }

    public Account(Map<String, Object> payload) {
        super(payload);
    }

    public Account(String uri) throws HTTPError {
        super(uri);
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

    public Credit credit(int amount, String description) throws HTTPError {
        return credit(amount, description, null, null, null);
    }

    public Debit debit(
            int amount,
            String description,
            String source_uri,
            String appears_on_statement_as,
            Map<String, String> meta) throws HTTPError {
        Map<String, Object> payload = new HashMap<String, Object>();
        payload.put("amount", amount);
        if (description != null)
            payload.put("description", description);
        if (source_uri != null)
            payload.put("source", source_uri);
        if (appears_on_statement_as != null)
            payload.put("appears_on_statement_as", appears_on_statement_as);
        if (meta != null)
            payload.put("meta", meta);
        return debits.create(payload);
    }

    public Debit debit(int amount) throws HTTPError {
        return debit(amount, null, null, null, null);
    }

    public Debit debit(int amount, String appears_on_statement_as) throws HTTPError {
        return debit(amount, null, null, appears_on_statement_as, null);
    }

    public Hold hold(
            int amount,
            String description,
            String source_uri,
            Map<String, String> meta) throws HTTPError {
        Map<String, Object> payload = new HashMap<String, Object>();
        payload.put("amount", amount);
        if (description != null)
            payload.put("description", description);
        if (source_uri != null)
            payload.put("source", source_uri);
        if (meta != null)
            payload.put("meta", meta);
        return holds.create(payload);
    }

    public Hold hold(int amount) throws HTTPError {
        return hold(amount, null, null, null);
    }

    public void associateBankAccount(String bank_account_uri) throws HTTPError {
        Map<String, Object> payload = new HashMap<String, Object>();
        payload.put("bank_account_uri", bank_account_uri);
        Map<String, Object> response = client.put(uri, payload);
        deserialize(response);
    }

    /**
     * This method is used to promote an account to a merchant account, which will
     * set the is_identity_verified field to True.  The merchant map will depend
     * on whether the account is for an individual or a business; see the following:
     * <ul>
     *     <li><a href=https://github.com/balanced/balanced-api/blob/master/resources/accounts.rst#promote-a-buyer-account-to-a-merchant>Person Merchant</a></li>
     *     <li><a href=https://github.com/balanced/balanced-api/blob/master/resources/accounts.rst#create-a-business-merchant>Business Merchant</a></li>
     * </ul>
     *
     * <p>
     * Should this method return an HTTP 300 response, you must request additional information
     * from the merchant; see <a href=https://www.balancedpayments.com/help#q146>What is KYC?</a>
     * <p>
     * Once you receive the merchant URI from the Balanced API, use the
     * promoteToMerchant(String merchant_uri) method to underwrite the account as
     * a merchant account.
     *
     * @param merchant_map A map with the merchant's information, which can be
     *                     for a person or a business.
     * @see promoteToMerchant
     */
    public void promoteToMerchant(Map<String, Object> merchant_map) throws HTTPError {
        Map<String, Object> payload = new HashMap<String, Object>();
        payload.put("merchant", merchant_map);
        Map<String, Object> response = client.put(uri, payload);
        deserialize(response);
    }

    /**
     * This method should be called after and only after a merchant is redirected to
     * Balanced and Balanced consequently redirects the merchant back to you with a
     * merchant_uri parameter on a query string. It is generated when
     * the marketplace redirects its user to Balanced as a result of a
     * MoreInformationRequired exception that's thrown (http status code 300).
     * <p>
     * You should use the promoteToMerchant(Map<String, Object> merchant_map) method
     * when attempting to communicate as a first attempt with Balanced.
     *
     * @param merchant_uri The URI of the merchant returned by the Balanced API following identity verification
     * @see promoteToMerchant
     */
    public void promoteToMerchant(String merchant_uri) throws HTTPError {
        Map<String, Object> payload = new HashMap<String, Object>();
        payload.put("merchant_uri", merchant_uri);
        Map<String, Object> response = client.put(uri, payload);
        deserialize(response);
    }

    public void associateCard(String card_uri) throws HTTPError {
        Map<String, Object> payload = new HashMap<String, Object>();
        payload.put("card_uri", card_uri);
        Map<String, Object> response = client.put(uri, payload);
        deserialize(response);
    }
}
