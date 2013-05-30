package com.balancedpayments;

import java.util.HashMap;
import java.util.Map;

import com.balancedpayments.core.Resource;
import com.balancedpayments.core.ResourceField;
import com.balancedpayments.core.ResourceQuery;
import com.balancedpayments.errors.HTTPError;
import com.balancedpayments.errors.MultipleResultsFound;
import com.balancedpayments.errors.NoResultsFound;

public class Marketplace extends Resource {

    @ResourceField(mutable=true)
    public String name;

    @ResourceField(mutable=true)
    public String support_email_address;

    @ResourceField(mutable=true)
    public String support_phone_number;

    @ResourceField(mutable=true)
    public String domain_url;

    @ResourceField(mutable=true)
    public Map<String, String> meta;

    @ResourceField()
    public Integer in_escrow;

    @ResourceField(field="bank_accounts_uri")
    public BankAccount.Collection bank_accounts;

    @ResourceField(field="cards_uri")
    public Card.Collection cards;

    @ResourceField(field="accounts_uri")
    public Account.Collection accounts;

    @ResourceField(field="debits_uri")
    public Debit.Collection debits;

    @ResourceField(field="credits_uri")
    public Credit.Collection credits;

    @ResourceField(field="holds_uri")
    public Hold.Collection holds;

    @ResourceField(field="refunds_uri")
    public Refund.Collection refunds;

    @ResourceField(field="events_uri")
    public Event.Collection events;

    @ResourceField(field="callbacks_uri")
    public Callback.Collection callbacks;

    @ResourceField()
    public Account owner_account;

    @ResourceField()
    public Customer owner_customer;

    public static ResourceQuery<Marketplace> query() {
        return new ResourceQuery<Marketplace>(
                Marketplace.class,
                String.format("/v%s/%s", Settings.VERSION, "marketplaces"));
    }

    public static Marketplace mine() throws NoResultsFound, MultipleResultsFound, HTTPError {
        return query().one();
    }

    public Marketplace() {
        super();
    }

    public Marketplace(String uri) throws HTTPError {
        super(uri);
    }

    public BankAccount tokenizeBankAccount(
            String name,
            String account_number,
            String routing_number) throws HTTPError {
        Map<String, Object> payload = new HashMap<String, Object>();
        payload.put("name", name);
        payload.put("account_number", account_number);
        payload.put("routing_number", routing_number);
        return bank_accounts.create(payload);
    }

    public BankAccount tokenizeBankAccount(
            String name,
            String account_number,
            String routing_number,
            String type) throws HTTPError {
        Map<String, Object> payload = new HashMap<String, Object>();
        payload.put("name", name);
        payload.put("account_number", account_number );
        payload.put("routing_number", routing_number);
        payload.put("type", type);
        return bank_accounts.create(payload);
    }

    public Credit creditBankAccount(
            int amount,
            String description,
            String account_number,
            String name,
            String routing_number,
            String type) throws HTTPError {
        Map<String, Object> payload = new HashMap<String, Object>();
        payload.put("amount", amount);
        if (description != null)
            payload.put("description", description);
        Map<String, Object> bank_account = new HashMap<String, Object>();
        bank_account.put("account_number", account_number);
        bank_account.put("name", name);
        bank_account.put("routing_number", routing_number);
        if (type != null)
            bank_account.put("type", type);
        payload.put("bank_account", bank_account);
        return credits.create(payload);
    }

    public Card tokenizeCard(
            String street_address,
            String city,
            String region,
            String postal_code,
            String name,
            String card_number,
            String security_code,
            int expiration_month,
            int expiration_year) throws HTTPError {
        return cards.create(
                street_address,
                city,
                region,
                postal_code,
                name,
                card_number,
                security_code,
                expiration_month,
                expiration_year);
    }

    public Account createAccount(
            String name,
            String email_address,
            Map<String, String> meta) throws HTTPError {
        Map<String, Object> payload = new HashMap<String, Object>();
        payload.put("email_address", email_address);
        if (meta != null)
            payload.put("meta", meta);
        return accounts.create(payload);
    }

    public Account createAccount(String name, String email_address) throws HTTPError {
        return createAccount(name, email_address, null);
    }

    public Account createAccount(String name) throws HTTPError {
        return createAccount(name, null, null);
    }

    public Account createBuyerAccount(
            String name,
            String email_address,
            String card_uri,
            Map<String, String> meta) throws HTTPError {
        Map<String, Object> payload = new HashMap<String, Object>();
        payload.put("card_uri", card_uri);
        if (name != null)
            payload.put("name", name);
        if (email_address != null)
            payload.put("email_address", email_address);
        if (meta != null)
            payload.put("meta", meta);
        return accounts.create(payload);
    }

    public Account createBuyerAccount(String card_uri) throws HTTPError {
        return createBuyerAccount(null, null, card_uri, null);
    }

    public Account createMerchantAccount(
                     String name,
                     String email_address,
                     String bank_account_uri,
                     String merchant_uri,
                     Map<String, String> meta) throws HTTPError {
        Map<String, Object> payload = new HashMap<String, Object>();
        payload.put("merchant_uri", merchant_uri);
        payload.put("bank_account_uri", bank_account_uri);
        if (name != null)
            payload.put("name", name);
        if (email_address != null)
            payload.put("email_address", email_address);
        if (meta != null)
            payload.put("meta", meta);
        return accounts.create(payload);
    }

    public Account createMerchantAccount(
             String name,
             String email_address,
             String bank_account_uri,
             Map<String, Object> merchant,
             Map<String, String> meta) throws HTTPError {
        Map<String, Object> payload = new HashMap<String, Object>();
        payload.put("merchant", merchant);
        payload.put("bank_account_uri", bank_account_uri);
        if (name != null)
            payload.put("name", name);
        if (email_address != null)
            payload.put("email_address", email_address);
        if (meta != null)
            payload.put("meta", meta);
        return accounts.create(payload);
    }

    public Callback registerCallback(String url) throws HTTPError {
        return callbacks.create(url);
    }

    @Override
    public void save() throws HTTPError {
        if (id == null && uri == null)
            uri = String.format("/v%s/%s", Settings.VERSION, "marketplaces");
        super.save();
    }
}
