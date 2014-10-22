package com.balancedpayments;

import static org.junit.Assert.*;

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
        assertTrue(marketplace.owner_customer instanceof Customer);
        assertEquals(marketplace.support_email_address, "support@example.com");
        assertEquals(marketplace.support_phone_number, "+16505551234");
        assertNotNull(marketplace.created_at);
        assertNotNull(marketplace.updated_at);
        assertFalse(marketplace.production);
        assertEquals(marketplace.in_escrow.toString(), "0");
        assertEquals(marketplace.unsettled_fees.toString(), "0");
        assertTrue(marketplace.href.contains("/marketplaces/TEST-MP"));
        assertTrue(marketplace.id.startsWith("TEST-MP"));
        assertTrue(marketplace.bank_accounts instanceof BankAccount.Collection);
        assertTrue(marketplace.cards instanceof Card.Collection);
        assertTrue(marketplace.credits instanceof Credit.Collection);
        assertTrue(marketplace.debits instanceof Debit.Collection);
        assertTrue(marketplace.disputes instanceof Dispute.Collection);
        assertTrue(marketplace.orders instanceof Order.Collection);
        assertTrue(marketplace.refunds instanceof Refund.Collection);
        assertTrue(marketplace.reversals instanceof Reversal.Collection);
        assertTrue(marketplace.card_holds instanceof CardHold.Collection);
        assertTrue(marketplace.events instanceof Event.Collection);
        assertTrue(marketplace.callbacks instanceof Callback.Collection);
        assertTrue(marketplace.customers instanceof Customer.Collection);
    }
}
