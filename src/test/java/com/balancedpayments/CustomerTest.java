package com.balancedpayments;

import java.util.ArrayList;
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
        Card card = createCard();
        BankAccount ba = createBankAccount();
        ba.associateToCustomer(customer);
        card.associateToCustomer(customer);


        Map<String, String> meta = new HashMap<String, String>();
        meta.put("facebook", "0192837465");
        customer.ein = "123456789";
        customer.email = "john@google.com";
        customer.meta = meta;
        customer.save();

        assertEquals(customer.address.toString(),
                "{city=San Francisco, line2=null, line1=965 Mission St, " +
                        "state=CA, postal_code=94103, country_code=US}");
        assertNull(customer.business_name);
        assertNotNull(customer.created_at);
        assertEquals(customer.dob_month.toString(), "1");
        assertEquals(customer.dob_year.toString(), "1980");
        assertEquals(customer.ein, "123456789");
        assertEquals(customer.email, "john@google.com");
        assertTrue(customer.href.contains("/customers/CU"));
        assertTrue(customer.id.startsWith("CU"));
        assertEquals(customer.merchant_status, "underwritten");
        assertEquals(customer.meta.get("facebook"), "0192837465");
        assertEquals(customer.name, "John Lee Hooker");
        assertEquals(customer.phone, "(904) 555-1796");
        assertEquals(customer.ssn_last4, "xxxx");
        assertNotNull(customer.updated_at);
        assertTrue(customer.bank_accounts instanceof BankAccount.Collection);
        assertTrue(customer.cards instanceof Card.Collection);
        assertTrue(customer.credits instanceof Credit.Collection);
        assertTrue(customer.debits instanceof Debit.Collection);
        assertTrue(customer.disputes instanceof Dispute.Collection);
        assertTrue(customer.orders instanceof Order.Collection);
        assertTrue(customer.refunds instanceof Refund.Collection);
        assertTrue(customer.reversals instanceof Reversal.Collection);
        assertTrue(customer.card_holds instanceof CardHold.Collection);
    }
}
