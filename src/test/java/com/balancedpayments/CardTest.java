package com.balancedpayments;

import org.junit.Before;
import org.junit.Test;
import org.junit.Rule;


import com.balancedpayments.errors.CannotCreate;
import com.balancedpayments.errors.HTTPError;
import com.balancedpayments.errors.NotCreated;
import com.balancedpayments.errors.APIError;
import org.junit.rules.ExpectedException;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;


public class CardTest  extends BaseTest {

    protected Card card;

    @Rule
    public ExpectedException apiError = ExpectedException.none();

    @Test
    public void testCardCreate() throws HTTPError {
        Card newCard = createCard(mp);

        card = new Card(newCard.uri);
        assertNotNull(card.uri);
        assertEquals("Visa", card.brand);
        assertEquals("visa", card.card_type);
        assertEquals("4113", card.last_four);
        assertTrue(card.is_valid);
        assertTrue(card.is_verified);
        assertEquals("failed", card.postal_code_check);
        assertEquals("passed", card.security_code_check);
    }

    @Test
    public void testCardDelete() throws CannotCreate, HTTPError, NotCreated {
        Customer buyer = createBusinessCustomer();
        Card card = createCard(mp);
        buyer.addCard(card);
        buyer.addCard(createCard(mp));

        Map<String, Object> payload = new HashMap<String, Object>();
        payload.put("amount", 100);
        payload.put("source_uri", card.uri);

        buyer.debit(payload);
        card.unstore();
        apiError.expect(APIError.class);
        buyer.debit(payload);
    }
}
