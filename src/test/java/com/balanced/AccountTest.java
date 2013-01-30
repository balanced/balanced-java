package com.balanced;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.balanced.errors.HTTPError;
import com.balanced.errors.InsufficientFunds;
import com.balanced.errors.MultipleResultsFound;
import com.balanced.errors.NoResultsFound;

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
    public void testCreditInsufficientFunds() throws HTTPError {
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
        Marketplace mp = Marketplace.mine();
        Account account = createBuyer(mp);
        Hold hold = account.hold(123);
        assertEquals(hold.account.id, account.id); 
    }
}

