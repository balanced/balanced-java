package com.balancedpayments;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.instanceOf;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.balancedpayments.errors.APIError;
import com.balancedpayments.errors.DuplicateAccountEmailAddress;
import com.balancedpayments.errors.HTTPError;
import com.balancedpayments.errors.MultipleResultsFound;
import com.balancedpayments.errors.NoResultsFound;
import com.balancedpayments.errors.NotCreated;

public class MarketplaceTest extends BaseTest {

    @Test(expected = APIError.class)
    public void testDoubleCreate() throws HTTPError {
        Marketplace marketplace2 = new Marketplace();
        marketplace2.save();
    }

    @Test
    public void testMine() throws HTTPError, NoResultsFound, MultipleResultsFound {
        Marketplace mine = Marketplace.mine();
        assertEquals(mine.id, mp.id);
    }

    @Test
    public void testOwner() throws HTTPError, NoResultsFound, MultipleResultsFound {
        Marketplace mine = Marketplace.mine();
        assertNotNull(mine.owner_customer);
    }

    @Test
    public void testMarketplaceResourceFields() throws HTTPError,
            NoResultsFound, MultipleResultsFound{
        Marketplace marketplace = Marketplace.mine();

        assertEquals(marketplace.domain_url, "example.com");
        assertEquals(marketplace.name, "Test Marketplace");
        assertThat(marketplace.owner_customer, instanceOf(Customer.class));
        assertEquals(marketplace.support_email_address, "support@example.com");
        assertEquals(marketplace.support_phone_number, "+16505551234");
        assertNotNull(marketplace.created_at);
        assertNotNull(marketplace.updated_at);
        assertFalse(marketplace.production);
        assertEquals(marketplace.in_escrow.toString(), "0");
        assertEquals(marketplace.unsettled_fees.toString(), "0");
        assertTrue(marketplace.href.contains("/marketplaces/TEST-MP"));
        assertTrue(marketplace.id.startsWith("TEST-MP"));
        assertThat(marketplace.bank_accounts, instanceOf(BankAccount.Collection.class));
        assertThat(marketplace.cards, instanceOf(Card.Collection.class));
        assertThat(marketplace.credits, instanceOf(Credit.Collection.class));
        assertThat(marketplace.debits, instanceOf(Debit.Collection.class));
        assertThat(marketplace.disputes, instanceOf(Dispute.Collection.class));
        assertThat(marketplace.orders, instanceOf(Order.Collection.class));
        assertThat(marketplace.refunds, instanceOf(Refund.Collection.class));
        assertThat(marketplace.reversals, instanceOf(Reversal.Collection.class));
        assertThat(marketplace.card_holds, instanceOf(CardHold.Collection.class));
        assertThat(marketplace.events, instanceOf(Event.Collection.class));
        assertThat(marketplace.callbacks, instanceOf(Callback.Collection.class));
        assertThat(marketplace.customers, instanceOf(Customer.Collection.class));
    }
}
