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
import static org.junit.Assert.assertNotNull;


public class CardTest extends BaseTest {

    protected Card card;

    @Rule
    public ExpectedException apiError = ExpectedException.none();

    @Test
    public void testCardCreate() throws HTTPError {
        Map<String, Object> meta = new HashMap<String, Object>();
        meta.put("user_id", "0192837465");
        meta.put("my-own-customer-id", "12345");

        Map<String, Object> address = new HashMap<String, Object>();
        address.put("line1", "123 PL SE");
        address.put("city", "San Francisco");
        address.put("state", "CA");
        address.put("postal_code", "98405");
        address.put("country_code", "USA");

        Map<String, Object> payload = new HashMap<String, Object>();
        payload.put("name", "John Jameson");
        payload.put("number", "5105105105105100");
        payload.put("expiration_month", 12);
        payload.put("expiration_year", 2020);
        payload.put("cvv", "123");
        payload.put("address", address);
        payload.put("meta", meta);

        Card card = new Card(payload);
        card.save();

        assertTrue(card.is_verified);
        assertEquals("MasterCard", card.brand);
        assertNull(card.customer);
        assertNotNull(card.number);
        assertEquals(12, card.expiration_month.intValue());
        assertEquals(2020, card.expiration_year.intValue());
        assertEquals("xxx", card.cvv);
        assertEquals("John Jameson", card.name);
        assertEquals("98405", card.address.get("postal_code"));
        assertEquals("123 PL SE", card.address.get("line1"));
        assertEquals("12345", card.meta.get("my-own-customer-id"));
    }

    @Test
    public void testCardDelete() throws CannotCreate, HTTPError, NotCreated {
        Customer buyer = createBusinessCustomer();
        Card card = createCard();
        card.unstore();
        //apiError.expect(APIError.class);
    }

    @Test
    public void testCardResourceFields() throws HTTPError {
        Card card = createCreditableCard();

        assertNotNull(card.address);
        assertNull(card.avs_postal_match);
        assertNull(card.avs_result);
        assertNull(card.avs_street_match);
        assertNotNull(card.bank_name);
        assertNotNull(card.can_credit);
        assertNotNull(card.can_debit);
        assertNotNull(card.category);
        assertNotNull(card.created_at);
        assertNull(card.cvv_match);
        assertNull(card.cvv_result);
        assertNotNull(card.expiration_month);
        assertNotNull(card.expiration_year);
        assertNotNull(card.fingerprint);
        assertNotNull(card.href);
        assertNotNull(card.id);
        assertNotNull(card.is_verified);
        assertNotNull(card.meta);
        assertNotNull(card.name);
        assertNotNull(card.number);
        assertNotNull(card.type);
        assertNotNull(card.updated_at);
        assertNotNull(card.card_holds);
        assertNull(card.customer);
        assertNotNull(card.debits);
        assertNotNull(card.disputes);
        assertNotNull(card.credits);
    }
}
