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
    public void testCreateCredit() throws HTTPError {
        Card card = createCard();

        Map<String, Object> debitPayload = new HashMap<String, Object>();
        debitPayload.put("amount", 1000);
        card.debit(debitPayload);

        BankAccount ba = createBankAccount();

        Map<String, Object> creditPayload = new HashMap<String, Object>();
        creditPayload.put("amount", 1000);
        creditPayload.put("appears_on_statement_as", "Tasty Treats");

        Credit credit = ba.credit(creditPayload);

        assertEquals(1000, credit.amount.intValue());
        assertEquals("Tasty Treats", credit.appears_on_statement_as);
    }

    @Test
    public void testReversal() throws HTTPError {
        Card card = createCard();

        Map<String, Object> debitPayload = new HashMap<String, Object>();
        debitPayload.put("amount", 1000);
        card.debit(debitPayload);

        BankAccount ba = createBankAccount();

        Map<String, Object> creditPayload = new HashMap<String, Object>();
        creditPayload.put("amount", 1000);
        creditPayload.put("appears_on_statement_as", "Tasty Treats");

        Credit credit = ba.credit(creditPayload);

        Reversal reversal = credit.reverse();

        assertEquals(credit.amount, reversal.amount);
    }
}
