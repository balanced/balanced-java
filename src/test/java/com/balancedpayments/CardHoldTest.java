package com.balancedpayments;

import com.balancedpayments.errors.*;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class CardHoldTest extends BaseTest {

    @Test
    public void testCardHoldCreate() throws HTTPError {
        Card card = createCard();

        Map<String, Object> payload = new HashMap<String, Object>();
        payload.put("amount", 2000);

        CardHold cardHold = card.hold(payload);
        cardHold.save();

        assertEquals(2000, cardHold.amount.intValue());
    }

    @Test
    public void testCardHoldCapturePartial() throws HTTPError {
        Card card = createCard();

        Map<String, Object> payload = new HashMap<String, Object>();
        payload.put("amount", 2000);

        CardHold cardHold = card.hold(payload);

        Map<String, Object> capturePayload = new HashMap<String, Object>();
        capturePayload.put("amount", 1000);

        Debit debit = cardHold.capture(capturePayload);
        assertEquals(2000, cardHold.amount.intValue());
        assertEquals(1000, debit.amount.intValue());
        assertEquals(card.href, debit.source.href);
    }

    @Test
    public void testCardHoldCapture() throws HTTPError {
        Card card = createCard();

        Map<String, Object> payload = new HashMap<String, Object>();
        payload.put("amount", 2000);

        CardHold cardHold = card.hold(payload);

        Debit debit = cardHold.capture();
        assertEquals(2000, debit.amount.intValue());
        assertEquals(card.href, debit.source.href);
    }

    @Test
    public void testCardHoldVoid() throws HTTPError, NotCreated {
        Card card = createCard();

        Map<String, Object> payload = new HashMap<String, Object>();
        payload.put("amount", 2000);

        CardHold cardHold = card.hold(payload);

        assertNull(cardHold.voided_at);

        cardHold.unstore();
        cardHold.reload();

        assertNotNull(cardHold.voided_at);
    }

    @Test
    public void testCardHoldResourceFields() throws HTTPError {
        Card card = createNonCreditableCard();

        Map<String, Object> payload = new HashMap<String, Object>();
        payload.put("amount", 2000);
        payload.put("description", "Test hold");

        CardHold cardHold = card.hold(payload);

        Map<String, String> meta = new HashMap<String, String>();
        meta.put("facebook", "0192837465");
        cardHold.meta = meta;
        cardHold.save();

        assertEquals(cardHold.amount.intValue(), 2000);
        assertNotNull(cardHold.created_at);
        assertEquals(cardHold.currency, "USD");
        assertEquals(cardHold.description, "Test hold");
        assertNotNull(cardHold.expires_at);
        assertNull(cardHold.failure_reason);
        assertNull(cardHold.failure_reason_code);
        assertTrue(cardHold.href.contains("/card_holds/HL"));
        assertTrue(cardHold.id.contains("HL"));
        assertEquals(cardHold.card.href, card.href);
        assertNull(cardHold.debit);
        assertNull(cardHold.order);
        assertEquals(cardHold.meta.get("facebook"), "0192837465");
        assertEquals(cardHold.status, "succeeded");
        assertTrue(cardHold.transaction_number.startsWith("HL"));
        assertNotNull(cardHold.updated_at);
        assertNull(cardHold.voided_at);
        assertTrue(cardHold.debits instanceof Debit.Collection);
        assertTrue(cardHold.events instanceof Event.Collection);
    }
}
