package com.balancedpayments;

import com.balancedpayments.core.ResourceQuery;
import com.balancedpayments.errors.CannotCreate;
import com.balancedpayments.errors.HTTPError;
import com.balancedpayments.errors.MultipleResultsFound;
import com.balancedpayments.errors.NoResultsFound;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class DebitTest extends BaseTest {

    @Test
    public void testDebitRetrieve() {

    }

    @Test
    public void testRefund() throws CannotCreate, HTTPError, NoResultsFound, MultipleResultsFound {
        Marketplace mp = Marketplace.mine();
        Account account = createBuyer(mp);
        Debit debit = account.debit(123);
        Refund refund = debit.refund();
        assertEquals(refund.amount, debit.amount);
    }

    @Test
    public void testDebitFilter() throws CannotCreate, HTTPError, NoResultsFound, MultipleResultsFound {
        Marketplace mp = Marketplace.mine();
        Account buyer;
        Debit[] debits = new Debit[3];

        buyer = createBuyer(mp);
        debits[0] = buyer.debit(55);
        debits[1] = buyer.debit(66);
        debits[2] = buyer.debit(77);

        ResourceQuery<Debit> query = buyer.debits.query().filter("amount", "=", 77);
        assertEquals(1, query.total());
        assertEquals(debits[2].id, query.first().id);

        query = buyer.debits.query().filter("amount", 77);
        assertEquals(1, query.total());
        assertEquals(debits[2].id, query.first().id);

        query = (
            buyer
            .debits
            .query()
            .filter("amount", "<", 77)
            .order_by("created_at", true)
        );
        assertEquals(2, query.total());
        ArrayList<Debit> all_debits = query.all();
        assertEquals(debits[0].id, all_debits.get(0).id);
        assertEquals(debits[1].id, all_debits.get(1).id);

        query = (
                buyer
                .debits
                .query()
                .filter("amount", ">", 55)
                .filter("amount", "<", 77)
                .order_by("amount", false)
            );
        assertEquals(1, query.total());
        all_debits = query.all();
        assertEquals(debits[1].id, all_debits.get(0).id);
    }

    @Test
    public void testRetrieveDebit() throws HTTPError, NoResultsFound, MultipleResultsFound {
        Marketplace mp = Marketplace.mine();
        Account account = mp.createBuyerAccount("William Henry Cavendish III", null, null, null);
        String description = "Goods and services";
        Card card = mp.tokenizeCard(
                "123 Fake Street",
                "Jollywood",
                null,
                "90210",
                "William Henry Cavendish III",
                "4112344112344113",
                "123",
                12,
                2013);
        account.associateCard(card.uri);
        Debit newDebit = account.debit(10000, description, card.uri, null, null);
        Debit debit = new Debit(newDebit.uri);
        assertNotNull("Debit should not be null", debit);
        assertEquals("Debit description should be \"" + description + "\"", description, debit.description);
    }

    @Test
    public void testCustomerDebitAttributes() throws HTTPError {
        Customer customer = createBusinessCustomer();
        Card card = mp.tokenizeCard(
                "123 Fake Street",
                "Jollywood",
                null,
                "90210",
                "William Henry Cavendish III",
                "4112344112344113",
                "123",
                12,
                2013);
        customer.addCard(card.uri);

        Map<String, Object> payload = new HashMap<String, Object>();
        payload.put("amount", 10000);
        payload.put("description", "Goods and services");
        payload.put("source_uri", card.uri);

        Debit newDebit = customer.debit(payload);
        Debit debit = new Debit(newDebit.uri);

        assertNotNull(debit.getCustomer());
        assertNotNull(debit.getAccount());
        assertNotNull("Hold should be null", debit.getHold());
    }

    @Test
    public void testAccountDebitAttributes() throws HTTPError, NoResultsFound, MultipleResultsFound {
        Marketplace mp = Marketplace.mine();
        Account account = mp.createBuyerAccount("William Henry Cavendish III", null, null, null);
        String description = "Goods and services";
        Card card = mp.tokenizeCard(
                "123 Fake Street",
                "Jollywood",
                null,
                "90210",
                "William Henry Cavendish III",
                "4112344112344113",
                "123",
                12,
                2013);
        account.associateCard(card.uri);
        Debit newDebit = account.debit(10000, description, card.uri, null, null);
        Debit debit = new Debit(newDebit.uri);

        assertNotNull("Account should not be null", debit.getAccount());
        assertNotNull("Customer should not be null", debit.getCustomer());
        assertNull("Hold should be null", debit.getHold());
    }
}
