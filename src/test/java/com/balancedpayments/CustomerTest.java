package com.balancedpayments;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.balancedpayments.errors.NotCreated;
import org.junit.Test;

import com.balancedpayments.errors.HTTPError;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNotNull;

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
    public void testMerchantStatusNoMatch() throws HTTPError {
        Map<String, Object> payload = new HashMap<String, Object>();

        payload.put("name", "John Lee Hooker");
        payload.put("phone", "(904) 555-1796");

        Map<String, String> address = new HashMap<String, String>();
        address.put("city", "San Francisco");
        address.put("state", "CA");
        address.put("postal_code", "94103");
        address.put("line1", "965 Mission St");
        address.put("country_code", "US");
        payload.put("address", address);

        payload.put("ssn_last4", "3209");

        Customer merchant = new Customer(payload);
        merchant.save();
        assertEquals("no-match", merchant.merchant_status);
    }

    @Test
    public void testMerchantStatusUnderwritten() throws HTTPError {
        Customer merchant = createPersonCustomer();
        assertEquals("underwritten", merchant.merchant_status);
    }

    @Test
    public void testBankAccounts() throws HTTPError {
        Customer customer = createPersonCustomer();
        BankAccount ba = createBankAccount();
        assertNotNull(ba);
        assertNotNull(ba.href);
        ba.associateToCustomer(customer);
        assertEquals(ba.href, customer.bank_accounts.iterator().next().href);
    }

    @Test
    public void testCards() throws HTTPError {
        Customer customer = createPersonCustomer();
        Card card = createCard();
        assertNotNull(card);
        assertNotNull(card.href);
        card.associateToCustomer(customer);
        assertEquals(card.href, customer.cards.iterator().next().href);
    }

    @Test
    public void testUnstore() throws HTTPError, NotCreated {
        Customer buyer = createBusinessCustomer();
        buyer.unstore();
    }

    @Test(expected=com.balancedpayments.errors.APIError.class)
    public void testUnstoreCustomerNotExist() throws HTTPError, NotCreated {
        Customer buyer = new Customer("/customers/12j5hl21lu35gui");
        buyer.unstore();
    }

    @Test
    public void testCustomerList() throws HTTPError {
        Customer.Collection customerz = new Customer.Collection(Customer.resource_href);
        for (Customer c : customerz) {
            System.out.println(c.name);
        }
        ArrayList<Customer> customers = Customer.query().all();
        assertTrue(customers.size() > 0);
    }

    @Test
    public void testCustomerResourceFields() throws HTTPError {
        Customer customer = createPersonCustomer();

        assertNotNull(customer.address);
        assertNull(customer.business_name);
        assertNotNull(customer.created_at);
        assertNotNull(customer.dob_month);
        assertNotNull(customer.dob_year);
        assertNull(customer.ein);
        assertNull(customer.email);
        assertNotNull(customer.href);
        assertNotNull(customer.id);
        assertNull(customer.destination);
        assertNull(customer.source);
        assertNotNull(customer.merchant_status);
        assertNotNull(customer.meta);
        assertNotNull(customer.name);
        assertNotNull(customer.phone);
        assertNotNull(customer.ssn_last4);
        assertNotNull(customer.updated_at);
        assertNotNull(customer.bank_accounts);
        assertNotNull(customer.card_holds);
        assertNotNull(customer.cards);
        assertNotNull(customer.credits);
        assertNotNull(customer.debits);
        assertNotNull(customer.disputes);
        assertNotNull(customer.orders);
        assertNotNull(customer.refunds);
        assertNotNull(customer.reversals);
    }
}
