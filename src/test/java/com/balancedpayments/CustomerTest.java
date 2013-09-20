package com.balancedpayments;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.balancedpayments.errors.HTTPError;

public class CustomerTest extends BaseTest {

    @Test
    public void testCreatePersonCustomer() throws HTTPError {
        Map<String, Object> payload = personCustomerPayload();
        Customer customer = new Customer(payload);
        customer.save();
    }

    @Test
    public void testCreateBusinessCustomer() throws HTTPError {
        Map<String, Object> payload = businessCustomerPayload();
        Customer customer = new Customer(payload);
        customer.save();
    }

    @Test
    public void testCards() throws HTTPError {
        Customer customer = createPersonCustomer();
        Card active_card = customer.activeCard();
        assertNull(active_card);
        Card card = createCard(mp);
        customer.addCard(card);
        active_card = customer.activeCard();
        assertNotNull(active_card);
        active_card.invalidate();
        active_card = customer.activeCard();
        assertNull(active_card);
    }

    @Test
    public void testBankAccounts() throws HTTPError {
        Customer customer = createPersonCustomer();
        BankAccount active_bank_account = customer.activeBankAccount();
        assertNull(active_bank_account);
        BankAccount bank_account = createBankAccount(mp);
        customer.addBankAccount(bank_account);
        active_bank_account = customer.activeBankAccount();
        assertNotNull(active_bank_account);
    }

    @Test
    public void testDebitCredit() throws HTTPError {
        Customer buyer = createBusinessCustomer();
        Card card = createCard(mp);
        buyer.addCard(card);
        assertEquals(buyer.activeCard().id, card.id);

        Customer seller = createBusinessCustomer();
        BankAccount bank_account = createBankAccount(mp);
        seller.addBankAccount(bank_account);

        Map<String, String> meta = new HashMap<String, String>();
        meta.put("ships", "tomorrow");
        Debit debit = buyer.debit(
            1234,
            "something tangy",
            null,
            "TANGY",
            seller.uri,
            meta);
        assertEquals(debit.source.id, card.id);

        Credit credit = seller.credit(
            1200,
            "sold something tangy",
            null,
            "TANGY",
            debit.uri,
            meta);
        assertEquals(credit.bank_account.id, bank_account.id);
    }

    @Test
    public void testDebitSourceCreditDestination() throws HTTPError {
        Customer buyer = createBusinessCustomer();
        Card card = createCard(mp);
        buyer.addCard(card);
        buyer.addCard(createCard(mp));
        assertFalse(buyer.activeCard().id.equals(card.id));

        Customer seller = createBusinessCustomer();
        BankAccount bank_account = createBankAccount(mp);
        seller.addBankAccount(bank_account);
        seller.addBankAccount(createBankAccount(mp));
        assertFalse(seller.activeBankAccount().id.equals(bank_account.id));

        Map<String, String> meta = new HashMap<String, String>();
        meta.put("ships", "tomorrow");
        Debit debit = buyer.debit(
            1234,
            "something tangy",
            card.uri,
            "TANGY",
            seller.uri,
            meta);
        // FIXME: ?
        //assertEquals(debit.card.id, card.id);

        Credit credit = seller.credit(
            1200,
            "sold something tangy",
            bank_account.uri,
            "TANGY",
            debit.uri,
            meta);
        assertEquals(credit.bank_account.id, bank_account.id);
    }

    @Test
    public void debitWithMultipleActiveCards() throws HTTPError {
        Customer customer = createPersonCustomer();
        Card card1 = createCard(mp);
        customer.addCard(card1);
        Card card2 = createCard(mp);
        customer.addCard(card2);
        assertEquals(card2.id, customer.activeCard().id);
        Debit debit = customer.debit(24995, card1.uri);
        assertEquals(card1.id, debit.source.id);
    }

    @Test
    public void holdWithMultipleActiveCards() throws HTTPError {
        Customer customer = createPersonCustomer();
        Card card1 = createCard(mp);
        customer.addCard(card1);
        Card card2 = createCard(mp);
        customer.addCard(card2);
        assertEquals(card2.id, customer.activeCard().id);
        Hold hold = customer.hold(39995, "My Description", card1.uri, null);
        // TODO: assertEquals(card1.id, hold.source.id);
        // There is no hold.source yet, but there probably should be!
        // So for now we can just take it all the way through capture and
        // then ensure that the Debit has the correct card associated:
        Debit debit = hold.capture();
        assertEquals(card1.id, debit.source.id);
    }
}
