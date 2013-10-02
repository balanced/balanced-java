package com.balancedpayments;

import com.balancedpayments.core.ResourceQuery;
import com.balancedpayments.errors.*;
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
        Account account = createBuyer(mp);
        Debit debit = account.debit(123);
        Refund refund = debit.refund();
        assertEquals(refund.amount, debit.amount);
    }

    @Test
    public void testRefundGet() throws CannotCreate, HTTPError, NoResultsFound, MultipleResultsFound {
        Account account = createBuyer(mp);
        Debit debit = account.debit(123);
        Refund newRefund = debit.refund();
        Refund refund = new Refund(newRefund.uri);
        assertEquals(newRefund.uri, refund.uri);
    }

    @Test
    public void testDebitBankAccountVerified() throws HTTPError {
        Customer customer = new Customer();
        customer.save();

        BankAccount ba = createBankAccount(mp);
        customer.addBankAccount(ba);

        BankAccountVerification bankAccountVerification = ba.verify();
        bankAccountVerification.confirm(1, 1);
        bankAccountVerification.reload();

        Map<String, Object> payload = new HashMap<String, Object>();
        payload.put("amount", 100000);

        Debit debit = ba.debit(payload);

        assertTrue(debit.status.equals("succeeded"));
        assertEquals(100000, (int)debit.amount);
    }

    @Test
    public void testDebitBankAccountUnverified() throws HTTPError {
        Customer customer = new Customer();
        customer.save();

        BankAccount ba = createBankAccount(mp);
        customer.addBankAccount(ba);

        Map<String, Object> payload = new HashMap<String, Object>();
        payload.put("amount", 100000);

        try {
            Debit debit = ba.debit(payload);
            fail("Debiting an unverified bank account should fail");
        }
        catch (APIError e) {
            assertEquals("funding-source-not-debitable", e.category_code);
        }
    }

    @Test
    public void testDebitFilter() throws CannotCreate, HTTPError, NoResultsFound, MultipleResultsFound {
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
        Account account = mp.createBuyerAccount("William Henry Cavendish III", null, null, null);
        String description = "Goods and services";
        Card card = createCard(mp);
        account.associateCard(card.uri);
        Debit newDebit = account.debit(10000, description, card.uri, null, null);
        Debit debit = new Debit(newDebit.uri);
        assertNotNull("Debit should not be null", debit);
        assertEquals("Debit description should be \"" + description + "\"", description, debit.description);
    }

    @Test
    public void testCustomerDebitAttributes() throws HTTPError {
        Customer customer = createBusinessCustomer();
        Card card = createCard(mp);
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
        Account account = mp.createBuyerAccount("William Henry Cavendish III", null, null, null);
        String description = "Goods and services";
        Card card = createCard(mp);
        account.associateCard(card.uri);
        Debit newDebit = account.debit(10000, description, card.uri, null, null);
        Debit debit = new Debit(newDebit.uri);

        assertNotNull("Account should not be null", debit.getAccount());
        assertNotNull("Customer should not be null", debit.getCustomer());
        assertNotNull("Hold should not be null", debit.getHold());
    }
}
