package com.balancedpayments;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;

import com.balancedpayments.errors.HTTPError;
import com.balancedpayments.errors.MultipleResultsFound;
import com.balancedpayments.errors.NoResultsFound;


public class BaseTest {

    public static String KEY_MARKETPLACE = "984f92c847e111e2a7a0026ba7f8ec28";

    protected Marketplace mp;

    @Before
    public void setUp() throws NoResultsFound, MultipleResultsFound, HTTPError {
    	String location = System.getProperty("balanced_location", Settings.location);
    	String key = System.getProperty("balanced_key", KEY_MARKETPLACE);
    	Settings.configure(location, key);
        this.mp = Marketplace.mine();
    }

    protected Marketplace createMarketplace() throws HTTPError {
        Settings.key = null;
        APIKey k = new APIKey();
        k.save();
        Settings.key = k.secret;

        Marketplace mp = new Marketplace();
        mp.save();
        return mp;
    }

    protected Card createCard(Marketplace mp) throws HTTPError {
        return mp.tokenizeCard(
                "123 Fake Street",
                "Jollywood",
                null,
                "90210",
                "Homer Jay",
                "4112344112344113",
                "123",
                12,
                2013);
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
        Map<String, Object> merchant = new HashMap<String, Object>();
        merchant.put("type", "person");
        merchant.put("name", "William James");
        merchant.put("tax_id", "393-48-3992");
        merchant.put("street_address", "167 West 74th Street");
        merchant.put("postal_code", "10023");
        merchant.put("dob", "1842-01-01");
        merchant.put("phone_number", "+16505551234");
        merchant.put("country_code", "USA");
        return mp.createMerchantAccount(
                null,
                null,
                bank_account.uri,
                merchant,
                null);
    }

    protected void fundEscrow(Marketplace mp) throws HTTPError {
        createBuyer(mp).debit(2000000);
    }
}
