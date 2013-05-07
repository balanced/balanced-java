package com.balancedpayments;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.balancedpayments.errors.HTTPError;
import com.balancedpayments.errors.InsufficientFunds;
import com.balancedpayments.errors.MultipleResultsFound;
import com.balancedpayments.errors.NoResultsFound;

public class CustomerTest extends BaseTest {

    @Test
    public void testCreatePersonCustomer() throws HTTPError {
        Map<String, Object> payload = personCustomerPayload();
        Customer customer = new Customer(payload);
        customer.save();
    }
    
    @Test
    public void testCreateBusinessCustomer() throws HTTPError {
        Map<String, Object> payload = businessCustomerPayload();
        Customer customer = new Customer(payload);
        customer.save();
    }
    
    @Test
    public void testCards() throws HTTPError {
        Customer customer = createPersonCustomer();
        Card active_card = customer.activeCard();
        assertNull(active_card);
        Card card = createCard(mp);
        customer.addCard(card);
        active_card = customer.activeCard();
        assertNotNull(active_card);
        active_card.invalidate();
        active_card = customer.activeCard();
        assertNull(active_card);
    }
    
    @Test
    public void testBankAccounts() throws HTTPError {
        Customer customer = createPersonCustomer();
        BankAccount active_bank_account = customer.activeBankAccount();
        assertNull(active_bank_account);
        BankAccount bank_account = createBankAccount(mp);
        customer.addBankAccount(bank_account);
        active_bank_account = customer.activeBankAccount();
        assertNotNull(active_bank_account);
    }
    
    @Test
    public void testDebitCredit() throws HTTPError {
        Customer buyer = createBusinessCustomer();
        Card card = createCard(mp);
        buyer.addCard(card);
        
        Customer seller = createBusinessCustomer();
        BankAccount bank_account = createBankAccount(mp);
        seller.addBankAccount(bank_account);
        
        Map<String, String> meta = new HashMap<String, String>();
        meta.put("ships", "tomorrow");
        Debit debit = buyer.debit(
            1234,
            "something tangy",
            null,
            "TANGY",
            seller.uri,
            meta);
        assertEquals(debit.card.id, card.id);
        
        Credit credit = seller.credit(
            1200,
            "sold something tangy",
            null,
            "TANGY",
            debit.uri,
            meta);
        assertEquals(credit.bank_account.id, card.id);
    }
}
