package com.balancedpayments;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.balancedpayments.errors.APIError;
import com.balancedpayments.errors.DuplicateAccountEmailAddress;
import com.balancedpayments.errors.HTTPError;
import com.balancedpayments.errors.MultipleResultsFound;
import com.balancedpayments.errors.NoResultsFound;
import com.balancedpayments.errors.NotCreated;

public class MarketplaceTest extends BaseTest {

    @Test(expected = APIError.class)
    public void testDoubleCreate() throws HTTPError {
        Marketplace marketplace2 = new Marketplace();
        marketplace2.save();
    }

    @Test
    public void testMine() throws HTTPError, NoResultsFound, MultipleResultsFound {
        Marketplace mine = Marketplace.mine();
        assertEquals(mine.id, mp.id);
    }

    @Test
    public void testOwner() throws HTTPError, NoResultsFound, MultipleResultsFound {
        assertNotNull(mp.owner_account);
        assertNotNull(mp.owner_customer);
    }

    @Test(expected=NoResultsFound.class)
    public void testNoMine() throws HTTPError, NoResultsFound, MultipleResultsFound {
        APIKey key = new APIKey();
        key.save();
        Balanced.configure(key.secret);
        Marketplace.mine();
    }

    @Test
    public void testTokenizeBankAccount() throws HTTPError, NoResultsFound, MultipleResultsFound {
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
        Card card = createCard(mp);

        assertEquals("Homer Jay", card.name);
        assertNull(card.card_number);
        assertEquals("4113", card.last_four);
        assertEquals(2016, card.expiration_year.intValue());
        assertEquals(12, card.expiration_month.intValue());
    }

    @Test
    public void testCreateAccount() throws HTTPError, NoResultsFound, MultipleResultsFound {
        Account account = mp.createAccount("Homer Jay");
        assertEquals(account.roles.length, 0);
    }

    @Test
    public void testCreateBuyerAccount() throws HTTPError {
        Card card = createCard(mp);
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
    public void testDuplicateEmailAddresses() throws HTTPError, NoResultsFound, MultipleResultsFound {
        Marketplace mp = createMarketplace();
        mp.createAccount("Me", "me@example.com");
        mp.createAccount("Me", "me@example.com");
    }

    @Test
    public void testCallbackRegistration() throws HTTPError, NotCreated, NoResultsFound, MultipleResultsFound {
        Marketplace mp = createMarketplace();
        assertEquals(mp.callbacks.total(), 0);
        Callback callback = mp.registerCallback("http://www.example.com/cb");
        assertEquals(mp.callbacks.total(), 1);
        callback.delete();
        assertEquals(mp.callbacks.total(), 0);
    }

    @Test
    public void testEvents() throws HTTPError, NotCreated, InterruptedException, NoResultsFound, MultipleResultsFound {
        String balancedEnv = System.getenv("BALANCED_ENV");
        org.junit.Assume.assumeTrue((balancedEnv != "staging"));
        Marketplace mp = createMarketplace();
        int prev = mp.events.total();
        Account account = createBuyer(mp);
        account.debit(123);
        int cur = mp.events.total();
        int count = 0;
        while (cur == prev && count < 60) {
            System.out.println(String.format("waiting for events - %d, %d == %d...", count, cur, prev));
            Thread.sleep(2000);  // 2 seconds
            count += 1;
            cur = mp.events.total();
        }
        assertTrue(cur > prev);
        mp.events.all();
    }
}
