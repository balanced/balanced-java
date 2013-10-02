package com.balancedpayments;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

import com.balancedpayments.errors.HTTPError;
import com.balancedpayments.errors.InsufficientFunds;
import com.balancedpayments.errors.MultipleResultsFound;
import com.balancedpayments.errors.NoResultsFound;

public class AccountTest extends BaseTest {

    @Test
    public void testAssociatedFunding() throws HTTPError, NoResultsFound, MultipleResultsFound {
        Marketplace mp = Marketplace.mine();
        Account account = mp.createAccount("Homer Jay");
        assertEquals(account.bank_accounts.total(), 0);
        assertEquals(account.cards.total(), 0);
        assertEquals(account.roles.length, 0);
        assertFalse(Arrays.asList(account.roles).contains("buyer"));
        assertFalse(Arrays.asList(account.roles).contains("merchant"));

        BankAccount ba = createBankAccount(mp);
        account.associateBankAccount(ba.uri);
        assertEquals(account.bank_accounts.total(), 1);
        assertEquals(account.cards.total(), 0);
        assertFalse(Arrays.asList(account.roles).contains("buyer"));
        assertFalse(Arrays.asList(account.roles).contains("merchant"));

        Card card = createCard(mp);
        account.associateCard(card.uri);
        assertEquals(account.bank_accounts.total(), 1);
        assertEquals(account.cards.total(), 1);
        assertTrue(Arrays.asList(account.roles).contains("buyer"));
        assertFalse(Arrays.asList(account.roles).contains("merchant"));
    }

    @Test
    public void testCredit() throws HTTPError {
        fundEscrow(mp);
        Account account = createMerchant(mp);
        account.credit(123);
    }

    @Test(expected=InsufficientFunds.class)
    public void testCreditInsufficientFunds() throws HTTPError, NoResultsFound, MultipleResultsFound {
        Marketplace mp = createMarketplace();
        Account account = createMerchant(mp);
        account.credit(123);
    }

    @Test
    public void testDebit() throws HTTPError, NoResultsFound, MultipleResultsFound {
        Marketplace mp = Marketplace.mine();
        Account account = createBuyer(mp);
        account.debit(123);
    }

    @Test
    public void testHold() throws HTTPError, NoResultsFound, MultipleResultsFound {
        Account account = createBuyer(mp);
        Card card = createCard(mp);
        account.associateCard(card.uri);
        Hold newHold = account.hold(123, null, card.uri, null);
        Hold hold = new Hold(newHold.uri);
        assertEquals(account.id, hold.account.id);
        assertTrue(hold.source.uri.contains(card.id));
    }

    @Test
    public void testPromoteToMerchant() throws HTTPError, NoResultsFound, MultipleResultsFound {
        Marketplace mp = Marketplace.mine();
        Account account = createBuyer(mp);
        assertFalse(Arrays.asList(account.roles).contains("merchant"));
        account.promoteToMerchant(buildMerchantPayload());
        assertTrue(Arrays.asList(account.roles).contains("merchant"));
    }
}

