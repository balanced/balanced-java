package com.balancedpayments;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.junit.Rule;


import com.balancedpayments.errors.CannotCreate;
import com.balancedpayments.errors.HTTPError;
import com.balancedpayments.errors.NotCreated;
import com.balancedpayments.errors.APIError;
import org.junit.rules.ExpectedException;


public class CardTest  extends BaseTest {

    protected Card card;

    @Rule
    public ExpectedException apiError = ExpectedException.none();

    @Test
    public void testCardDelete() throws CannotCreate, HTTPError, NotCreated {
        Customer buyer = createBusinessCustomer();
        Card card = createCard(mp);
        buyer.addCard(card);
        buyer.addCard(createCard(mp));
        buyer.debit(100, "", card.uri, "", null, null);
        card.unstore();
        apiError.expect(APIError.class);
        buyer.debit(100, "", card.uri, "", null, null);
    }
}
