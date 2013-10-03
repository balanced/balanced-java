package com.balancedpayments;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;

import com.balancedpayments.errors.HTTPError;
import com.balancedpayments.errors.MultipleResultsFound;
import com.balancedpayments.errors.NoResultsFound;


public class BaseTest {

    public static String KEY_MARKETPLACE = "ak-test-162blqRxbgzRNOsRhWloVQ3hHJBNosJQJ";

    protected Marketplace mp;

    @Before
    public void setUp() throws NoResultsFound, MultipleResultsFound, HTTPError {
    	/*String key = System.getProperty("balanced_key", KEY_MARKETPLACE);
    	Balanced.getInstance().configure(key);
        this.mp = Marketplace.mine();*/
        APIKey key = new APIKey();
        key.save();
        Balanced.configure(key.secret);
        Marketplace marketplace = new Marketplace();
        marketplace.save();
        this.mp = marketplace;
    }

    protected Marketplace createMarketplace() throws HTTPError, NoResultsFound, MultipleResultsFound {
        APIKey key = new APIKey();
        key.save();
        Balanced.configure(key.secret);

        Marketplace mp = new Marketplace();
        mp.save();
        return mp;
    }

    protected Card createCard(Marketplace mp) throws HTTPError {
        Map<String, Object> payload = new HashMap<String, Object>();
        payload.put("street_address", "123 Fake Street");
        payload.put("city", "Jollywood");
        payload.put("postal_code", "90210");
        payload.put("name", "Homer Jay");
        payload.put("card_number", "4112344112344113");
        payload.put("security_code", "123");
        payload.put("expiration_month", 12);
        payload.put("expiration_year", 2016);

        return mp.tokenizeCard(payload);
    }

    protected BankAccount createBankAccount(Marketplace mp) throws HTTPError {
        return mp.tokenizeBankAccount(
                "Homer Jay",
                "112233a",
                "121042882");
    }

    protected Account createBuyer(Marketplace mp) throws HTTPError {
        Card card = createCard(mp);
        return mp.createBuyerAccount(card.uri);
    }

    protected Account createMerchant(Marketplace mp) throws HTTPError {
        BankAccount bank_account = createBankAccount(mp);
        Map<String, Object> merchant = buildMerchantPayload();
        return mp.createMerchantAccount(
                null,
                null,
                bank_account.uri,
                merchant,
                null);
    }

    protected Map<String, Object> buildMerchantPayload() {
        Map<String, Object> merchant = new HashMap<String, Object>();
        merchant.put("type", "person");
        merchant.put("name", "William James");
        merchant.put("tax_id", "393-48-3992");
        merchant.put("street_address", "167 West 74th Street");
        merchant.put("postal_code", "10023");
        merchant.put("dob", "1842-01-01");
        merchant.put("phone_number", "+16505551234");
        merchant.put("country_code", "USA");

        return merchant;
    }

    protected void fundEscrow(Marketplace mp) throws HTTPError {
        createBuyer(mp).debit(2000000);
    }

    protected Customer createPersonCustomer() throws HTTPError {
        Customer customer = new Customer(personCustomerPayload());
        customer.save();
        return customer;
    }

    protected Map<String, Object> personCustomerPayload() {
        Map<String, Object> payload = new HashMap<String, Object>();

        payload.put("name", "John Lee Hooker");
        payload.put("twitter", "@balanced");
        payload.put("phone", "(904) 555-1796");

        Map<String, String> meta = new HashMap<String, String>();
        meta.put("meta can store", "any flat key/value data you like");
        meta.put("github", "https://github.com/balanced");
        meta.put("more_additional_data", "54.8");
        payload.put("meta", meta);

        payload.put("facebook", "https://facebook.com/balanced");

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
        payload.put("twitter", "@balanced");
        payload.put("phone", "(904) 555-1796");

        Map<String, String> meta = new HashMap<String, String>();
        meta.put("meta can store", "any flat key/value data you like");
        meta.put("github", "https://github.com/balanced");
        meta.put("more_additional_data", "54.8");
        payload.put("meta", meta);

        payload.put("facebook", "https://facebook.com/balanced");

        Map<String, String> address = new HashMap<String, String>();
        address.put("city", "San Francisco");
        address.put("state", "CA");
        address.put("postal_code", "94103");
        address.put("line1", "965 Mission St");
        address.put("country_code", "US");
        payload.put("address", address);

        payload.put("ssn_last4", "3209");

        payload.put("business_name", "Balanced");
        payload.put("ein", "123456789");

        return payload;
    }
}
