package com.balancedpayments;

import java.util.HashMap;
import java.util.Map;

import com.balancedpayments.errors.NotCreated;
import org.junit.Test;

import com.balancedpayments.errors.HTTPError;

import static org.junit.Assert.*;

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
        try {
            active_card.unstore();
        }
        catch (Exception e) {}
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

        Map<String, Object> payload = new HashMap<String, Object>();
        payload.put("amount", 1234);
        payload.put("description", "something tangy");
        payload.put("appears_on_statement_as", "TANGY");
        payload.put("on_behalf_of_uri", seller.uri);
        payload.put("meta", meta);

        Debit debit = buyer.debit(payload);
        assertEquals(debit.source.id, card.id);

        Map<String, Object> creditPayload = new HashMap<String, Object>();
        creditPayload.put("amount", 1200);
        creditPayload.put("description", "sold something tangy");
        creditPayload.put("appears_on_statement_as", "TANGY");
        creditPayload.put("debit_uri", debit.uri);
        creditPayload.put("meta", meta);

        Credit credit = seller.credit(creditPayload);
        //assertEquals(credit.bank_account.id, bank_account.id);
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

        Map<String, Object> payload = new HashMap<String, Object>();
        payload.put("amount", 1234);
        payload.put("description", "something tangy");
        payload.put("source_uri", card.uri);
        payload.put("appears_on_statement_as", "TANGY");
        payload.put("on_behalf_of_uri", seller.uri);
        payload.put("meta", meta);

        Debit debit = buyer.debit(payload);

        // FIXME: ?
        //assertEquals(debit.card.id, card.id);

        Map<String, Object> creditPayload = new HashMap<String, Object>();
        creditPayload.put("amount", 1200);
        creditPayload.put("description", "sold something tangy");
        creditPayload.put("destination_uri", bank_account.uri);
        creditPayload.put("appears_on_statement_as", "TANGY");
        creditPayload.put("debit_uri", debit.uri);
        creditPayload.put("meta", meta);

        Credit credit = seller.credit(creditPayload);
        //assertEquals(credit.bank_account.id, bank_account.id);
    }

    @Test
    public void testUnstore() throws HTTPError, NotCreated {
        Customer buyer = createBusinessCustomer();
        buyer.unstore();
    }

    @Test(expected=com.balancedpayments.errors.APIError.class)
    public void testUnstoreCustomerNotExist() throws HTTPError, NotCreated {
        Customer buyer = new Customer("/v1/customers/12j5hl21lu35gui");
        buyer.unstore();
    }

    @Test
    public void testCustomerList() throws HTTPError {
        Customer.Collection customers = mp.customers;
        assertTrue(customers.getClass().equals(Customer.Collection.class));
        assertTrue(customers.total() > 0);
    }
}
