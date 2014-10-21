package com.balancedpayments;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.balancedpayments.errors.*;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.instanceOf;

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
    public void testCreateCreditCard() throws HTTPError, FundingInstrumentNotCreditable {
        // prefund escrow
        Card fundingCard = createCard();
        Map<String, Object> debitPayload = new HashMap<String, Object>();
        debitPayload.put("amount", 250000);
        fundingCard.debit(debitPayload);

        // credit funds to Card
        Card card = createCreditableCard();
        Map<String, Object> creditPayload = new HashMap<String, Object>();
        creditPayload.put("amount", 250000);
        Credit credit = card.credit(creditPayload);

        assertEquals("succeeded", credit.status);
        assertEquals(250000, credit.amount.intValue());
    }

    @Test
    public void testCreateCreditCardCanCreditFalse() throws HTTPError {
        // prefund escrow
        Card fundingCard = createCard();
        Map<String, Object> debitPayload = new HashMap<String, Object>();
        debitPayload.put("amount", 250000);
        fundingCard.debit(debitPayload);

        // attempt to credit funds to Card
        Card card = createNonCreditableCard();
        Map<String, Object> creditPayload = new HashMap<String, Object>();
        creditPayload.put("amount", 250000);

        try {
            card.credit(creditPayload);
            fail("Attempting to credit a non-creditable Card should fail");
        }
        catch (FundingInstrumentNotCreditable e) {}
    }

    @Test
     public void testCreateCreditCardLimit() throws HTTPError, FundingInstrumentNotCreditable {
        // prefund escrow
        Card fundingCard = createCard();
        Map<String, Object> debitPayload = new HashMap<String, Object>();
        debitPayload.put("amount", 250005);
        fundingCard.debit(debitPayload);

        // attempt to credit funds to Card
        Card card = createCreditableCard();
        Map<String, Object> creditPayload = new HashMap<String, Object>();
        creditPayload.put("amount", 250001);

        try {
            card.credit(creditPayload);
        }
        catch (HTTPError e) {
            assertEquals(409, ((APIError)e).status_code.intValue());
            assertEquals("amount-exceeds-limit", ((APIError)e).category_code);
        }
    }

    @Test
    public void testCreateCreditCardRequireName() throws HTTPError, FundingInstrumentNotCreditable {
        // prefund escrow
        Card fundingCard = createCard();
        Map<String, Object> debitPayload = new HashMap<String, Object>();
        debitPayload.put("amount", 250000);
        fundingCard.debit(debitPayload);

        // attempt to credit funds to Card
        Map<String, Object> payload = new HashMap<String, Object>();
        payload.put("number", "4342561111111118");
        payload.put("expiration_month", 05);
        payload.put("expiration_year", 2016);
        Card card = new Card(payload);
        card.save();

        Map<String, Object> creditPayload = new HashMap<String, Object>();
        creditPayload.put("amount", 250000);

        try {
            card.credit(creditPayload);
        }
        catch (HTTPError e) {
            assertEquals(400, ((APIError)e).status_code.intValue());
            assertEquals("name-required-to-credit", ((APIError)e).category_code);
        }
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

    @Test
    public void testCreditResourceFields() throws HTTPError {
        Card card = createCard();

        Map<String, Object> debitPayload = new HashMap<String, Object>();
        debitPayload.put("amount", 1000);
        card.debit(debitPayload);

        BankAccount ba = createBankAccount();
        Map<String, Object> payload = personCustomerPayload();
        Customer customer = new Customer(payload);
        customer.save();
        ba.associateToCustomer(customer);

        Map<String, Object> creditPayload = new HashMap<String, Object>();
        creditPayload.put("amount", 1000);
        creditPayload.put("appears_on_statement_as", "Statement");
        creditPayload.put("description", "something");
        Credit credit = ba.credit(creditPayload);

        Map<String, String> meta = new HashMap<String, String>();
        meta.put("facebook", "0192837465");
        credit.meta = meta;
        credit.save();

        assertEquals(credit.amount.toString(), "1000");
        assertEquals(credit.appears_on_statement_as, "Statement");
        assertNotNull(credit.created_at);
        assertEquals(credit.currency, "USD");
        assertEquals(credit.description, "something");
        assertNull(credit.failure_reason);
        assertNull(credit.failure_reason_code);
        assertTrue(credit.href.contains("/credits/CR"));
        assertTrue(credit.id.startsWith("CR"));
        assertEquals(credit.customer.href, customer.href);
        assertEquals(credit.destination.href, ba.href);
        assertNull(credit.order);
        assertEquals(credit.meta.get("facebook"), "0192837465");
        assertEquals(credit.status, "succeeded");
        assertTrue(credit.transaction_number.startsWith("CR"));
        assertNotNull(credit.updated_at);
        assertThat(credit.events, instanceOf(Event.Collection.class));
        assertThat(credit.reversals, instanceOf(Reversal.Collection.class));

    }
}
