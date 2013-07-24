package com.balancedpayments;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

import com.balancedpayments.errors.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.Rule;


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

    @Test
    public void testCardCustomerDebit() throws HTTPError, CardUnassociated {
        Customer buyer = createBusinessCustomer();
        Card card = createCard(mp);
        buyer.addCard(card);
        card.refresh();
        card.debit(1000);
    }

    @Test
    public void testCardAccountDebit() throws HTTPError, CardUnassociated {
        Account buyer = createBuyer(mp);
        Card card = createCard(mp);
        buyer.associateCard(card.uri);
        card.refresh();
        card.debit(1000);
    }
}
