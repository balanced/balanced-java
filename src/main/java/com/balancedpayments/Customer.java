package com.balancedpayments;

import java.util.HashMap;
import java.util.Map;

import com.balancedpayments.core.Client;
import com.balancedpayments.core.Resource;
import com.balancedpayments.core.ResourceCollection;
import com.balancedpayments.core.ResourceQuery;
import com.balancedpayments.errors.HTTPError;

public class Customer extends Resource {

    public Map<String, String> address;
    public String bank_accounts_uri;
    public BankAccount.Collection bank_accounts;
    public String business_name;
    public String cards_uri;
    public Card.Collection cards;
    public String credits_uri;
    public Credit.Collection credits;
    public String debits_uri;
    public Debit.Collection debits;
    public String dob;
    public String ein;
    public String email;
    public String facebook;
    public String holds_uri;
    public Hold.Collection holds;
    public Boolean is_identity_verified;
    public Map<String, String> meta;
    public String name;
    public String phone;
    public String refunds_uri;
    public Refund.Collection refunds;
    public String ssn_last4;
    public String twitter;

    public static class Collection extends ResourceCollection<Customer> {
        public Collection(String uri) {
            super(Customer.class, uri);
        }
    };

    public static ResourceQuery<Customer> query() {
        return new ResourceQuery<Customer>(
                Customer.class,
                String.format("/v%s/%s", Settings.VERSION, "customers"));
    }

    public static Customer get(String uri) throws HTTPError {
        return new Customer((new Client()).get(uri));
    }

    public Customer() {
        super();
    }

    public Customer(Map<String, Object> payload) {
        super(payload);
    }

    public Customer(String uri) throws HTTPError {
        super(uri);
    }

    @Override
    public void save() throws HTTPError {
        if (id == null && uri == null)
            uri = String.format("/v%s/%s", Settings.VERSION, "customers");
        super.save();
    }

    public void addBankAccount(String bank_account_uri) throws HTTPError {
        Map<String, Object> payload = new HashMap<String, Object>();
        payload.put("bank_account_uri", bank_account_uri);
        Map<String, Object> response = client.put(uri, payload);
        deserialize(response);
    }

    public void addBankAccount(BankAccount bank_account) throws HTTPError {
        addBankAccount(bank_account.uri);
    }

    public BankAccount activeBankAccount() throws HTTPError {
        return (bank_accounts
                .query()
                .filter("is_valid", true)
                .order_by("created_at", false)
                .first());

    }

    public void addCard(String card_uri) throws HTTPError {
        Map<String, Object> payload = new HashMap<String, Object>();
        payload.put("card_uri", card_uri);
        Map<String, Object> response = client.put(uri, payload);
        deserialize(response);
    }

    public void addCard(Card card) throws HTTPError {
        addCard(card.uri);
    }

    public Card activeCard() throws HTTPError {
        return (cards
                .query()
                .filter("is_valid", true)
                .order_by("created_at", false)
                .first());
    }

    public Credit credit(
            int amount,
            String description,
            String destination_uri,
            String appears_on_statement_as,
            String debit_uri,
            Map<String, String> meta) throws HTTPError {
        Map<String, Object> payload = new HashMap<String, Object>();
        payload.put("amount", amount);
        if (description != null)
            payload.put("description", description);
        if (destination_uri != null)
            payload.put("destination_uri", destination_uri);
        if (appears_on_statement_as != null)
            payload.put("appears_on_statement_as", appears_on_statement_as);
        if (meta != null)
            payload.put("meta", meta);
        return credits.create(payload);
    }

    public Debit debit(
            int amount,
            String description,
            String source_uri,
            String appears_on_statement_as,
            String on_behalf_of_uri,
            Map<String, String> meta) throws HTTPError {
        Map<String, Object> payload = new HashMap<String, Object>();
        payload.put("amount", amount);
        if (description != null)
            payload.put("description", description);
        if (source_uri != null)
            payload.put("source_uri", source_uri);
        if (appears_on_statement_as != null)
            payload.put("appears_on_statement_as", appears_on_statement_as);
        if (meta != null)
            payload.put("meta", meta);
        if (on_behalf_of_uri != null)
            payload.put("on_behalf_of_uri", on_behalf_of_uri);
        return debits.create(payload);
    }

    @Override
    public Map<String, Object> serialize() {
        Map<String, Object> payload = new HashMap<String, Object>();

        payload.put("address", address);
        payload.put("business_name", business_name);
        payload.put("dob", dob);
        payload.put("ein", ein);
        payload.put("email", email);
        payload.put("facebook", facebook);
        payload.put("meta", meta);
        payload.put("name", name);
        payload.put("phone", phone);
        payload.put("ssn_last4", ssn_last4);
        payload.put("twitter", twitter);

        return payload;
    }

    @Override
    public void deserialize(Map<String, Object> payload) {
        super.deserialize(payload);
        address = (Map<String, String>) payload.get("address");
        bank_accounts_uri = (String) payload.get("bank_accounts_uri");
        bank_accounts = (bank_accounts_uri != null) ? new BankAccount.Collection(bank_accounts_uri) : null;
        business_name = (String) payload.get("business_name");
        cards_uri = (String) payload.get("cards_uri");
        cards = (cards_uri != null) ? new Card.Collection(cards_uri) : null;
        credits_uri = (String) payload.get("credits_uri");
        credits = (credits_uri != null) ? new Credit.Collection(credits_uri) : null;
        debits_uri = (String) payload.get("debits_uri");
        debits = (debits_uri != null) ? new Debit.Collection(debits_uri) : null;
        dob = (String) payload.get("dob");
        ein = (String) payload.get("ein");
        email = (String) payload.get("email");
        facebook= (String) payload.get("facebook");
        holds_uri = (String) payload.get("holds_uri");
        holds = (holds_uri != null) ? new Hold.Collection(holds_uri) : null;
        is_identity_verified = (Boolean) payload.get("is_identity_verified");
        meta = (Map<String, String>) payload.get("meta");
        name = (String) payload.get("name");
        phone = (String) payload.get("phone");
        refunds_uri = (String) payload.get("refunds_uri");
        refunds = (refunds_uri != null) ? new Refund.Collection(refunds_uri) : null;
        ssn_last4 = (String) payload.get("ssn_last4");
        twitter = (String) payload.get("twitter");
    }
}
