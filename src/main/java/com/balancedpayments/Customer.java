package com.balancedpayments;

import java.util.HashMap;
import java.util.Map;

import com.balancedpayments.core.Client;
import com.balancedpayments.core.Resource;
import com.balancedpayments.core.ResourceCollection;
import com.balancedpayments.core.ResourceField;
import com.balancedpayments.core.ResourceQuery;
import com.balancedpayments.errors.HTTPError;

public class Customer extends Resource {

    @ResourceField(mutable=true)
    public Map<String, String> address;

    @ResourceField(field="bank_accounts_uri")
    public BankAccount.Collection bank_accounts;

    @ResourceField(mutable=true)
    public String business_name;

    @ResourceField(field="cards_uri")
    public Card.Collection cards;

    @ResourceField(field="credits_uri")
    public Credit.Collection credits;

    @ResourceField(field="debits_uri")
    public Debit.Collection debits;

    @ResourceField(mutable=true)
    public String dob;

    @ResourceField(mutable=true)
    public String ein;

    @ResourceField(mutable=true)
    public String email;

    @ResourceField(mutable=true)
    public String facebook;

    @ResourceField(field="holds_uri")
    public Hold.Collection holds;

    @ResourceField()
    public Boolean is_identity_verified;

    @ResourceField(mutable=true)
    public Map<String, String> meta;

    @ResourceField(mutable=true)
    public String name;

    @ResourceField(mutable=true)
    public String phone;

    @ResourceField(field="refunds_uri")
    public Refund.Collection refunds;

    @ResourceField(mutable=true)
    public String ssn_last4;

    @ResourceField(mutable=true)
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
}
