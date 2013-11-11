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
        Map<String, Object> meta = new HashMap<String, Object>();
        meta.put("user_id", "0192837465");
        meta.put("my-own-customer-id", "12345");

        Map<String, Object> payload = new HashMap<String, Object>();
        payload.put("card_number", "5105105105105100");
        payload.put("expiration_month", 12);
        payload.put("expiration_year", 2020);
        payload.put("security_code", "123");
        payload.put("name", "John Jameson");
        payload.put("phone_number", "1234567890");
        payload.put("city", "San Francisco");
        payload.put("state", "CA");
        payload.put("postal_code", "98405");
        payload.put("street_address", "123 PL SE");
        payload.put("country_code", "USA");
        payload.put("meta", meta);

        Card card = new Card(payload);
        card.save();

        assertTrue(card.is_valid);
        assertTrue(card.is_verified);
        assertEquals("MasterCard", card.brand);
        assertEquals("mastercard", card.card_type);
        assertNull(card.customer);
        assertNull(card.card_number);
        assertEquals(12, card.expiration_month.intValue());
        assertEquals(2020, card.expiration_year.intValue());
        assertNull(card.security_code);
        assertEquals("John Jameson", card.name);
        assertNull(card.phone_number);
        assertNull(card.city);
        assertNull(card.state);
        assertEquals("98405", card.postal_code);
        assertEquals("123 PL SE", card.street_address);
        assertEquals("USA", card.country_code);
        assertEquals("12345", card.meta.get("my-own-customer-id"));
    }

    @Test
    public void testCardCreateViaMarketplace() throws HTTPError {
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
