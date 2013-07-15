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
    }

    /**
     * Returns an instance of an account
     *
     * @param uri The URI of the account you wish to instantiate
     * @return the account you wish to instantiate
     * @see Account
     */
    public static Account get(String uri) throws HTTPError {
        return new Account((new Client()).get(uri));
    }

    /**
     * Constructor for Account
     *
     */
    public Account() {
        super();
    }

    /**
     * Constructor that will create an account with the information given in
     * the payload
     *
     * @param payload See <a href="https://github.com/balanced/balanced-api/blob/master/resources/accounts.rst" target="_blank">Accounts API Reference</a>
     *                for the fields that you may include in the payload
     */
    public Account(Map<String, Object> payload) {
        super(payload);
    }


    /**
     * Instantiate an Account given an Account URI
     *
     * @param uri The URI for an existing account
     */
    public Account(String uri) throws HTTPError {
        super(uri);
    }


    /**
     * Credits a bank account for a given amount
     *
     * @param amount The amount to credit a bank account
     * @param description A description of the transaction
     * @param destination_uri The bank account URI the funds will be credited to
     * @param appears_on_statement_as What shows up on the bank statement
     * @param meta For persisting optional metadata about the transaction
     * @see Credit
     * @return a credit object
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
     * Credits a bank account for a given amount. Note that you may pass
     * additional parameters.
     *
     * @param amount The amount to credit a bank account
     * @see Credit
     * @return a credit object
     */
    public Credit credit(int amount) throws HTTPError {
        return credit(amount, null, null, null, null);
    }

    /**
     * Credits a bank account for a given amount
     *
     * @param amount The amount to credit a bank account
     * @param description A description of the transaction
     * @see Credit
     * @return a credit object
     */
    public Credit credit(int amount, String description) throws HTTPError {
        return credit(amount, description, null, null, null);
    }

    /**
     * Debits an account for a given amount; note that you may pass
     * additional parameters using debit(int amount, String appears_on_statement_as)
     *
     * @param amount Amount you wish to charge
     * @param description A description of the transaction
     * @param source_uri The URI of the funding source for the transaction
     * @param appears_on_statement_as What you would like to show up on a bank/card statement
     * @param meta  For persisting optional metadata about the transaction
     * @return a Debit object
     * @see Debit
     */
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

    /**
     * Debits an account for a given amount; note that you may pass additional
     * parameters to this method.
     *
     * @param amount Amount you wish to charge
     * @return a Debit object
     * @see Debit
     */
    public Debit debit(int amount) throws HTTPError {
        return debit(amount, null, null, null, null);
    }

    /**
     * Debits an account for a given amount; note that you may pass additional
     * parameters to this method.
     *
     * @param amount Amount you wish to charge
     * @param appears_on_statement_as What will show on the credit card statement
     * @return a Debit object
     * @see Debit
     */
    public Debit debit(int amount, String appears_on_statement_as) throws HTTPError {
        return debit(amount, null, null, appears_on_statement_as, null);
    }

    /**
     * Use this method to authorize a card for a given amount, which can later
     * be captured by calling Hold.capture
     *
     * @param amount The amount you wish to authorize
     * @param description A description of the hold, used for display purposes
     * @param source_uri The URI of the funding instrument, usually a credit/debit card
     * @param meta A map that can hold anything you want; basically a way to offload your data needs onto Balanced.
     * @return a Hold object
     * @see Hold
     */
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

    /**
     * Use this method to authorize a card for a given amount, which can later
     * be captured by calling Hold.capture.  Note that you may call this method
     * with additional parameters.  This method will default to authorizing the
     * last card associated with an account.
     *
     * @return a Hold object
     * @param amount The amount you wish to authorize
     * @see Hold
     */
    public Hold hold(int amount) throws HTTPError {
        return hold(amount, null, null, null);
    }


    /**
     * Use this method to associate a bank account to an account.
     *
     * @param bank_account_uri The URI of the bank account to be associated
     *                         with the account
     */
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
     *     <li><a href="https://github.com/balanced/balanced-api/blob/master/resources/accounts.rst#promote-a-buyer-account-to-a-merchant" target="_blank">Person Merchant</a></li>
     *     <li><a href="https://github.com/balanced/balanced-api/blob/master/resources/accounts.rst#create-a-business-merchant" target="_blank">Business Merchant</a></li>
     * </ul>
     *
     * <p>
     * Should this method return an HTTP 300 response, you must request additional information
     * from the merchant; see <a href="https://www.balancedpayments.com/help#q146" target="_blank">What is KYC?</a>
     * <p>
     * Once you receive the merchant URI from the Balanced API, use the
     * promoteToMerchant(String merchant_uri) method to underwrite the account as
     * a merchant account.
     *
     * @param merchant_map A map with the merchant's information, which can be
     *                     for a person or a business.
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
     */
    public void promoteToMerchant(String merchant_uri) throws HTTPError {
        Map<String, Object> payload = new HashMap<String, Object>();
        payload.put("merchant_uri", merchant_uri);
        Map<String, Object> response = client.put(uri, payload);
        deserialize(response);
    }

    /**
     * Use this method to associate a credit/debit card to an account.
     *
     * @param card_uri The URI of the card you wish to associate with the account
     */
    public void associateCard(String card_uri) throws HTTPError {
        Map<String, Object> payload = new HashMap<String, Object>();
        payload.put("card_uri", card_uri);
        Map<String, Object> response = client.put(uri, payload);
        deserialize(response);
    }
}
