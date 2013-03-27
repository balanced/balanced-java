package com.balancedpayments;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.balancedpayments.errors.DuplicateAccountEmailAddress;
import com.balancedpayments.errors.APIError;
import com.balancedpayments.errors.HTTPError;
import com.balancedpayments.errors.MultipleResultsFound;
import com.balancedpayments.errors.NoResultsFound;
import com.balancedpayments.errors.NotCreated;

public class MarketplaceTest extends BaseTest {

    @Test
    public void testCreate() throws HTTPError {
        Settings.key = null;
        APIKey key = new APIKey();
        key.save();
        Settings.key = key.secret;
        
        Marketplace mp = new Marketplace();
        mp.save();    
    }
    
    @Test(expected=APIError.class)
    public void testDoubleCreate() throws HTTPError {        
        Marketplace mp = new Marketplace();
        mp.save();
    }
    
    @Test
    public void testMine() throws HTTPError, NoResultsFound, MultipleResultsFound {
        Settings.key = null;
        APIKey key = new APIKey();
        key.save();
        Settings.key = key.secret;
        
        Marketplace mp = new Marketplace();
        mp.save();    
        
        Marketplace mine = Marketplace.mine();
        assertEquals(mine.id, mp.id);
    }
    
    @Test(expected=NoResultsFound.class)
    public void testNoMine() throws HTTPError, NoResultsFound, MultipleResultsFound {
        Settings.key = null;
        APIKey key = new APIKey();
        key.save();
        Settings.key = key.secret;
        
        Marketplace.mine();
    }
    
    @Test
    public void testTokenizeBankAccount() throws HTTPError, NoResultsFound, MultipleResultsFound {
        Marketplace mp = Marketplace.mine();
        BankAccount ba = mp.tokenizeBankAccount(
                "Homer Jay",
                "112233a",
                "121042882");
        assertEquals(ba.name, "Homer Jay");
        assertEquals(ba.account_number, "xxx233a");
        assertEquals(ba.routing_number, "121042882");
        assertEquals(ba.type, "checking");
    }
    
    @Test
    public void testCreditBankAccount() throws HTTPError, NoResultsFound, MultipleResultsFound {
        Marketplace mp = Marketplace.mine();
        fundEscrow(mp);
        mp.creditBankAccount(
                123,
                "Erotic Cakes",
                "Homer Jay",
                "112233a",
                "121042882",
                "checking");
    }
    
    @Test
    public void testTokenizeCard() throws HTTPError, NoResultsFound, MultipleResultsFound {
        Marketplace mp = Marketplace.mine();
        Card card = mp.tokenizeCard(
                "123 Fake Street",
                "Jollywood",
                null,
                "90210",
                "Homer Jay",
                "4112344112344113",
                "123",
                12,
                2013);
        assertEquals(card.name, "Homer Jay");
        assertEquals(card.card_number, "4113");
        assertEquals(card.last_four, "4113");
        assertEquals(card.expiration_year.intValue(), 2013);
        assertEquals(card.expiration_month.intValue(), 12);
    }
    
    @Test
    public void testCreateAccount() throws HTTPError, NoResultsFound, MultipleResultsFound {
        Marketplace mp = Marketplace.mine();
        Account account = mp.createAccount("Homer Jay");
        assertEquals(account.roles.length, 0);
    }
    
    @Test
    public void testCreateBuyerAccount() throws HTTPError {
        Card card = mp.tokenizeCard(
                "123 Fake Street",
                "Jollywood",
                null,
                "90210",
                "Homer Jay",
                "4112344112344113",
                "123",
                12,
                2013);
        Account account = mp.createBuyerAccount(
                "Homer Jay", 
                null,
                card.uri,
                null);
        assertTrue(Arrays.asList(account.roles).contains("buyer"));
        assertEquals(account.cards.total(), 1);
    }
    
    @Test
    public void testCreateMerchantAccount() throws HTTPError {
        BankAccount ba = mp.tokenizeBankAccount(
                "Homer Jay",
                "112233a",
                "121042882");
        Map<String, Object> merchant = new HashMap<String, Object>();
        merchant.put("type", "person");
        merchant.put("name", "William James");
        merchant.put("tax_id", "393-48-3992");
        merchant.put("street_address", "167 West 74th Street");
        merchant.put("postal_code", "10023");
        merchant.put("dob", "1842-01-01");
        merchant.put("phone_number", "+16505551234");
        merchant.put("country_code", "USA");
        Account account = mp.createMerchantAccount(
                "Homer Jay", 
                null,
                ba.uri,
                merchant,
                null);
        assertTrue(Arrays.asList(account.roles).contains("merchant"));
        assertEquals(account.bank_accounts.total(), 1);
    }
    
    @Test(expected=HTTPError.class)
    public void testMerchantVerificationFailure() throws HTTPError {
        // NOTE: postal_code == '99999' && region == 'EX' triggers verification failure
        BankAccount ba = mp.tokenizeBankAccount(
                "Homer Jay",
                "112233a",
                "121042882");
        Map<String, Object> merchant = new HashMap<String, Object>();
        merchant.put("type", "person");
        merchant.put("name", "William James");
        merchant.put("tax_id", "393-48-3992");
        merchant.put("street_address", "167 West 74th Street");
        merchant.put("postal_code", "99999");
        merchant.put("region", "EX");
        merchant.put("dob", "1842-01-01");
        merchant.put("phone_number", "+16505551234");
        merchant.put("country_code", "USA");
        mp.createMerchantAccount(
                "Homer Jay", 
                null,
                ba.uri,
                merchant,
                null);
    }
    
    @Test(expected=DuplicateAccountEmailAddress.class)
    public void testDuplicateEmailAddresses() throws HTTPError {
        Marketplace mp = createMarketplace();
        mp.createAccount("Me", "me@example.com");
        mp.createAccount("Me", "me@example.com");
    }
    
    @Test
    public void testCallbackRegistration() throws HTTPError, NotCreated {
        Marketplace mp = createMarketplace();
        assertEquals(mp.callbacks.total(), 0);
        Callback callback = mp.registerCallback("http://www.example.com/cb");
        assertEquals(mp.callbacks.total(), 1);
        callback.delete();
        assertEquals(mp.callbacks.total(), 0);
    }
    
    @Test
    public void testEvents() throws HTTPError, NotCreated, InterruptedException, NoResultsFound, MultipleResultsFound {
        Marketplace mp = createMarketplace();
        int prev = Marketplace.mine().events.total();
        Account account = createBuyer(mp);
        account.debit(123);
        int cur = Marketplace.mine().events.total();
        int count = 0;
        while (cur == prev && count < 10) {
            System.out.println(String.format("waiting for events - %d, %d == %d...", count, cur, prev));
            Thread.sleep(2000);  // 2 seconds
            count += 1;
            cur = Marketplace.mine().events.total();
        }
        assertTrue(cur > prev);
        mp.events.all();
    }
}
