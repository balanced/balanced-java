package com.balancedpayments;

import com.balancedpayments.errors.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.Rule;


import org.junit.rules.ExpectedException;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class OrderTest extends BaseTest {
    @Test
    public void testOrderCreateWithVerifiedMerchant() throws HTTPError {
        Customer merchant = createPersonCustomer();
        assertEquals("underwritten", merchant.merchant_status);

        Map<String, Object> payload = new HashMap<String, Object>();
        payload.put("description", "Test order #452");
        Order order = merchant.createOrder(payload);

        assertNotNull(order.href);
        assertEquals(order.merchant.href, merchant.href);
    }

    @Test
    public void testOrderDebitFromCreditTo() throws HTTPError {
        Customer merchant = createPersonCustomer();
        BankAccount ba = createBankAccount();
        ba.associateToCustomer(merchant);
        Order order = merchant.createOrder(null);
        Card card = createCard();

        Map<String, Object> debitPayload = new HashMap<String, Object>();
        debitPayload.put("description", "Debit for Order #234123");
        debitPayload.put("amount", 5000);

        Debit debit = order.debitFrom(card, debitPayload);
        order.reload();

        assertEquals(debit.order.href, order.href);
        assertEquals(5000, debit.amount.intValue());
        assertEquals(5000, order.amount.intValue());
        assertEquals(5000, order.amount_escrowed.intValue());

        Map<String, Object> creditPayload = new HashMap<String, Object>();
        creditPayload.put("description", "Payout for Order #234123");
        creditPayload.put("amount", 5000);

        Credit credit = order.creditTo(ba, creditPayload);
        order.reload();

        assertEquals(credit.order.href, order.href);
        assertEquals(5000, debit.amount.intValue());
        assertEquals(5000, order.amount.intValue());
        assertEquals(0, order.amount_escrowed.intValue());
    }

    @Test
    public void testOrderDebitCredit() throws HTTPError {
        Customer merchant = createPersonCustomer();
        Order order = merchant.createOrder(null);
        Card card = createCard();
        BankAccount ba = createBankAccount();
        ba.associateToCustomer(merchant);

        Map<String, Object> debitPayload = new HashMap<String, Object>();
        debitPayload.put("order", order.href);
        debitPayload.put("description", "Debit for Order #234123");
        debitPayload.put("amount", 5000);

        Debit debit = card.debit(debitPayload);
        order.reload();

        assertEquals(debit.order.href, order.href);
        assertEquals(5000, debit.amount.intValue());
        assertEquals(5000, order.amount.intValue());
        assertEquals(5000, order.amount_escrowed.intValue());

        Map<String, Object> creditPayload = new HashMap<String, Object>();
        creditPayload.put("order", order.href);
        creditPayload.put("description", "Payout for Order #234123");
        creditPayload.put("amount", 5000);

        Credit credit = ba.credit(creditPayload);
        order.reload();

        assertEquals(credit.order.href, order.href);
        assertEquals(5000, credit.amount.intValue());
        assertEquals(5000, order.amount.intValue());
        assertEquals(0, order.amount_escrowed.intValue());
    }

    @Test
    public void testOrderDebitBankAccountCredit() throws HTTPError {
        Customer merchant = createPersonCustomer();
        Order order = merchant.createOrder(null);
        BankAccount ba = createBankAccount();
        ba.associateToCustomer(merchant);
        BankAccount buyerBA = createBankAccount();
        BankAccountVerification verification = buyerBA.verify();
        verification.confirm(1, 1);

        Map<String, Object> debitPayload = new HashMap<String, Object>();
        debitPayload.put("order", order.href);
        debitPayload.put("description", "Debit for Order #234123");
        debitPayload.put("amount", 5000);

        Debit debit = buyerBA.debit(debitPayload);
        order.reload();

        assertEquals(debit.order.href, order.href);
        assertEquals(5000, debit.amount.intValue());
        assertEquals(5000, order.amount.intValue());
        assertEquals(5000, order.amount_escrowed.intValue());

        Map<String, Object> creditPayload = new HashMap<String, Object>();
        creditPayload.put("order", order.href);
        creditPayload.put("description", "Payout for Order #234123");
        creditPayload.put("amount", 5000);

        Credit credit = ba.credit(creditPayload);
        order.reload();

        assertEquals(credit.order.href, order.href);
        assertEquals(5000, credit.amount.intValue());
        assertEquals(5000, order.amount.intValue());
        assertEquals(0, order.amount_escrowed.intValue());
    }

    @Test
    public void testOrderNoOverCredit() throws HTTPError {
        Customer merchant = createPersonCustomer();
        Order order = merchant.createOrder(null);
        BankAccount ba = createBankAccount();
        ba.associateToCustomer(merchant);
        BankAccount buyerBA = createBankAccount();
        BankAccountVerification verification = buyerBA.verify();
        verification.confirm(1, 1);

        Map<String, Object> debitPayload = new HashMap<String, Object>();
        debitPayload.put("order", order.href);
        debitPayload.put("description", "Debit for Order #234123");
        debitPayload.put("amount", 5000);

        Debit debit = buyerBA.debit(debitPayload);
        order.reload();

        assertEquals(debit.order.href, order.href);
        assertEquals(5000, debit.amount.intValue());
        assertEquals(5000, order.amount.intValue());
        assertEquals(5000, order.amount_escrowed.intValue());

        Map<String, Object> creditPayload = new HashMap<String, Object>();
        creditPayload.put("order", order.href);
        creditPayload.put("description", "Payout for Order #234123");
        creditPayload.put("amount", 6000);

        Credit credit = null;

        try {
            credit = ba.credit(creditPayload);
        }
        catch (APIError e) {
            assertEquals(409, ((APIError)e).status_code.intValue());
        }

        order.reload();

        assertEquals(5000, order.amount.intValue());
        assertEquals(5000, order.amount_escrowed.intValue());
    }

    @Test
    public void testOrderResourceFields() throws HTTPError {
        Order order = createOrder();

        Map<String, String> meta = new HashMap<String, String>();
        meta.put("facebook", "0192837465");
        order.description = "New description for order";
        order.meta = meta;
        order.save();

        assertTrue(order.buyers instanceof Customer.Collection);
        assertTrue(order.credits instanceof Credit.Collection);
        assertTrue(order.debits instanceof Debit.Collection);
        assertTrue(order.merchant instanceof Customer);
        assertTrue(order.refunds instanceof Refund.Collection);
        assertTrue(order.reversals instanceof Reversal.Collection);
        assertTrue(order.href.contains("/orders/OR"));
        assertTrue(order.id.startsWith("OR"));
        assertEquals(order.delivery_address.toString(), "{city=null, line2=null, " +
                "line1=null, state=null, postal_code=null, country_code=null}");
        assertNotNull(order.created_at);
        assertNotNull(order.updated_at);
        assertEquals(order.currency, "USD");
        assertEquals(order.description, "New description for order");
        assertEquals(order.meta.get("facebook"), "0192837465");
        assertEquals(order.amount_escrowed.intValue(), 0);
        assertEquals(order.amount.intValue(), 5000);
    }
}