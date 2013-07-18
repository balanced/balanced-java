package com.balancedpayments;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

import com.balancedpayments.errors.CannotCreate;
import com.balancedpayments.errors.HTTPError;
import com.balancedpayments.errors.NotCreated;
import com.balancedpayments.errors.APIError;


public class CardTest  extends BaseTest {

    protected Card card;

    @Test(expected=APIError.class)
    public void testVerify() throws CannotCreate, HTTPError, NotCreated {
        Customer buyer = createBusinessCustomer();
        Card card = createCard(mp);
        buyer.addCard(card);
        buyer.addCard(createCard(mp));
        buyer.debit(100, "", card.uri, "", null, null);
        card.unstore();
        buyer.debit(100, "", card.uri, "", null, null);

    }
}
