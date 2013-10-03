package com.balancedpayments;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.balancedpayments.errors.*;
import org.junit.Test;

import com.balancedpayments.core.ResourceQuery;

public class CreditTest extends BaseTest {

    @Test
    public void testCreate() throws CannotCreate, HTTPError, NoResultsFound, MultipleResultsFound {
        Customer customer = createPersonCustomer();
        customer.addCard(createCard(mp));
        Map<String, Object> debitPayload = new HashMap<String, Object>();
        debitPayload.put("amount", 1000);
        customer.debit(debitPayload);

        Map<String, Object> bankAccountPayload = new HashMap<String, Object>();
        bankAccountPayload.put("name", "Homer Jay");
        bankAccountPayload.put("account_number", "11223345");
        bankAccountPayload.put("routing_number", "121042882");
        bankAccountPayload.put("type", "checking");

        Map<String, Object> creditPayload = new HashMap<String, Object>();
        creditPayload.put("amount", 1000);
        creditPayload.put("appears_on_statement_as", "Tasty Treats");
        creditPayload.put("bank_account", bankAccountPayload);

        Credit newCredit = new Credit(creditPayload);
        newCredit.save();
        Credit credit = new Credit(newCredit.uri);
        assertTrue(credit.amount == 1000);
        assertEquals("Tasty Treats", credit.appears_on_statement_as);
    }

    @Test
    public void testReversal() throws CannotCreate, HTTPError, NoResultsFound, MultipleResultsFound {
        Account account = createBuyer(mp);
        Debit debit = account.debit(123);
        Account account2 = createMerchant(mp);
        Credit credit = account2.credit(123);
        Reversal reversal = credit.reverse();
        assertEquals(reversal.amount, credit.amount);
    }

    @Test
    public void testReversalGet() throws CannotCreate, HTTPError, NoResultsFound, MultipleResultsFound {
        Account account = createBuyer(mp);
        Debit debit = account.debit(123);
        Account account2 = createMerchant(mp);
        Credit credit = account2.credit(123);
        Reversal rev = credit.reverse();
        Reversal reversal = new Reversal(rev.uri);
        assertEquals(rev.uri, reversal.uri);
    }
}
