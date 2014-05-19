package com.balancedpayments;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;

import com.balancedpayments.errors.HTTPError;
import com.balancedpayments.errors.MultipleResultsFound;
import com.balancedpayments.errors.NoResultsFound;


public class BaseTest {

    protected Marketplace mp;

    @Before
    public void setUp() throws NoResultsFound, MultipleResultsFound, HTTPError {
        ApiKey key = new ApiKey();
        key.save();
        Balanced.configure(key.secret);
        Marketplace marketplace = new Marketplace();
        marketplace.save();
        this.mp = marketplace;
    }

    protected Marketplace createMarketplace() throws HTTPError, NoResultsFound, MultipleResultsFound {
        ApiKey key = new ApiKey();
        key.save();
        Balanced.configure(key.secret);

        Marketplace mp = new Marketplace();
        mp.save();
        return mp;
    }

    protected Card createCard() throws HTTPError {

        Map<String, Object> addressPayload = new HashMap<String, Object>();
        addressPayload.put("line1", "123 Fake Street");
        addressPayload.put("city", "Jollywood");
        addressPayload.put("postal_code", "90210");

        Map<String, Object> payload = new HashMap<String, Object>();
        payload.put("name", "Homer Jay");
        payload.put("number", "4112344112344113");
        payload.put("cvv", "123");
        payload.put("expiration_month", 12);
        payload.put("expiration_year", 2016);
        payload.put("address", addressPayload);

        Card card = new Card(payload);
        card.save();

        return card;
    }

    protected Card createCreditableCard() throws HTTPError {
        Map<String, Object> payload = new HashMap<String, Object>();
        payload.put("name", "Johannes Bach");
        payload.put("number", "4342561111111118");
        payload.put("expiration_month", 05);
        payload.put("expiration_year", 2016);

        Card card = new Card(payload);
        card.save();

        return card;
    }

    protected Card createNonCreditableCard() throws HTTPError {
        Map<String, Object> payload = new HashMap<String, Object>();
        payload.put("name", "Georg Telemann");
        payload.put("number", "4111111111111111");
        payload.put("expiration_month", 12);
        payload.put("expiration_year", 2016);

        Card card = new Card(payload);
        card.save();

        return card;
    }

    protected BankAccount createBankAccount() throws HTTPError {
        Map<String, Object> payload = new HashMap<String, Object>();
        payload.put("name", "Johann Bernoulli");
        payload.put("routing_number", "121000358");
        payload.put("account_number", "9900000001");
        payload.put("type", "checking");

        BankAccount ba = new BankAccount(payload);
        ba.save();

        return ba;
    }

    protected Customer createPersonCustomer() throws HTTPError {
        Customer customer = new Customer(personCustomerPayload());
        customer.save();
        return customer;
    }

    protected Map<String, Object> personCustomerPayload() {
        Map<String, Object> payload = new HashMap<String, Object>();

        payload.put("name", "John Lee Hooker");
        payload.put("phone", "(904) 555-1796");
        payload.put("dob_month", 1);
        payload.put("dob_year", 1980);

        Map<String, String> meta = new HashMap<String, String>();
        meta.put("meta can store", "any flat key/value data you like");
        meta.put("github", "https://github.com/balanced");
        meta.put("more_additional_data", "54.8");
        payload.put("meta", meta);

        Map<String, String> address = new HashMap<String, String>();
        address.put("city", "San Francisco");
        address.put("state", "CA");
        address.put("postal_code", "94103");
        address.put("line1", "965 Mission St");
        address.put("country_code", "US");
        payload.put("address", address);

        payload.put("ssn_last4", "3209");

        return payload;
    }

    protected Customer createBusinessCustomer() throws HTTPError {
        Customer customer = new Customer(businessCustomerPayload());
        customer.save();
        return customer;
    }

    protected Map<String, Object> businessCustomerPayload() {
        Map<String, Object> payload = new HashMap<String, Object>();

        payload.put("name", "John Lee Hooker");
        payload.put("phone", "(904) 555-1796");
        payload.put("business_name", "Balanced");
        payload.put("ein", "123456789");

        Map<String, String> meta = new HashMap<String, String>();
        meta.put("meta can store", "any flat key/value data you like");
        meta.put("github", "https://github.com/balanced");
        meta.put("more_additional_data", "54.8");
        payload.put("meta", meta);

        Map<String, String> address = new HashMap<String, String>();
        address.put("city", "San Francisco");
        address.put("state", "CA");
        address.put("postal_code", "94103");
        address.put("line1", "965 Mission St");
        address.put("country_code", "USA");
        payload.put("address", address);

        return payload;
    }
}
