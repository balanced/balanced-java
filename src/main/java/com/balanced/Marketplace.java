package com.balanced;

import java.util.HashMap;
import java.util.Map;

import com.balanced.core.Resource;
import com.balanced.core.ResourceCollection;
import com.balanced.core.ResourceQuery;
import com.balanced.errors.HTTPError;
import com.balanced.errors.MultipleResultsFound;
import com.balanced.errors.NoResultsFound;

public class Marketplace extends Resource {
    
    public String name;
    public String support_email_address;
    public String support_phone_number;
    public String domain_url;
    public Integer in_escrow;
    public String bank_accounts_uri;
    public ResourceCollection<BankAccount> bank_accounts;
    public String cards_uri;
    public ResourceCollection<Card> cards;
    public String accounts_uri;
    public ResourceCollection<Account> accounts;
    public String debits_uri;
    public ResourceCollection<Debit> debits;
    public String credits_uri;
    public ResourceCollection<Credit> credits;
    public String holds_uri;
    public ResourceCollection<Hold> holds;
    public String refunds_uri;
    public ResourceCollection<Refund> refunds;
    public Map<String, String> meta;

    public static ResourceQuery<Marketplace> query() {
        return new ResourceQuery<Marketplace>(
                Marketplace.class,
                String.format("/v%s/%s", Settings.VERSION, "marketplaces"));
    }
    
    public static Marketplace mine() throws NoResultsFound, MultipleResultsFound, HTTPError {
        return query().one();
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
        Map<String, Object> payload = new HashMap<String, Object>();
        payload.put("street_address", street_address);
        payload.put("city", city);
        payload.put("region", region);
        payload.put("postal_code", postal_code);
        payload.put("name", name);
        payload.put("card_number", card_number);
        payload.put("expiration_month", expiration_month);
        payload.put("expiration_year", expiration_year);
        return cards.create(payload);
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

    @Override
    public void save() throws HTTPError {
        if (id == null && uri == null)
            uri = String.format("/v%s/%s", Settings.VERSION, "marketplaces");
        super.save();
    }

    @Override
    public Map<String, Object> serialize() {
        Map<String, Object> payload = new HashMap<String, Object>();
        payload.put("name", name);
        payload.put("support_email_address", support_email_address);
        payload.put("support_phone_number", support_phone_number);
        payload.put("domain_url", domain_url);
        payload.put("meta", meta);
        return payload;
    }

    @Override
    public void deserialize(Map<String, Object> payload) {
        super.deserialize(payload);
        name = (String) payload.get("name");
        support_email_address = (String) payload.get("support_email_address");
        support_phone_number = (String) payload.get("support_phone_number");
        domain_url = (String) payload.get("domain_url");
        in_escrow = ((Double) payload.get("in_escrow")).intValue();
        bank_accounts_uri = (String) payload.get("bank_accounts_uri");
        bank_accounts = new ResourceCollection<BankAccount>(BankAccount.class, bank_accounts_uri);
        cards_uri = (String) payload.get("cards_uri");
        cards = new ResourceCollection<Card>(Card.class, cards_uri);
        accounts_uri = (String) payload.get("accounts_uri");
        accounts = new ResourceCollection<Account>(Account.class, accounts_uri);
        credits_uri = (String) payload.get("credits_uri");
        credits = new ResourceCollection<Credit>(Credit.class, credits_uri);
        debits_uri = (String) payload.get("debits_uri");
        debits = new ResourceCollection<Debit>(Debit.class, debits_uri);
        holds_uri = (String) payload.get("holds_uri");
        holds = new ResourceCollection<Hold>(Hold.class, holds_uri);
        refunds_uri = (String) payload.get("refunds_uri");
        refunds = new ResourceCollection<Refund>(Refund.class, refunds_uri);
        meta = (Map<String, String>) payload.get("meta");
    }
}
