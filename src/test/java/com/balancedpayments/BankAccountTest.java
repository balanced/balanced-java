package com.balancedpayments;

import static org.junit.Assert.assertEquals;

import com.balancedpayments.errors.*;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import org.junit.rules.ExpectedException;

import java.util.Map;
import java.util.HashMap;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.instanceOf;

public class BankAccountTest  extends BaseTest {

    protected BankAccount ba;

    @Rule
    public ExpectedException apiError = ExpectedException.none();

    @Override
    @Before
    public void setUp() throws NoResultsFound, MultipleResultsFound, HTTPError {
        super.setUp();
        Customer customer = createPersonCustomer();
        ba = createBankAccount();
        ba.associateToCustomer(customer);
    }

    @Test
    public void testVerify() throws HTTPError {
        BankAccountVerification bav = ba.verify();
        ba.reload();

        assertEquals(ba.verification.id, bav.id);
        bav.confirm(1, 1);
        assertEquals(bav.attempts.intValue(), 1);
        assertEquals(bav.attempts_remaining.intValue(), 2);
        assertEquals(bav.deposit_status, "succeeded");
        assertEquals(bav.verification_status, "succeeded");
    }

    @Test(expected=BankAccountVerificationFailure.class)
    public void testDoubleVerify() throws HTTPError {
        ba.verify();
        ba.verify();
    }

    @Test
    public void testDeleteBankAccount() throws HTTPError, NotCreated {
    	BankAccount bankAccount = new BankAccount();
    	bankAccount.name = "Harry Fakester";
    	bankAccount.routing_number = "121042882";
    	bankAccount.account_number = "112233a";
    	bankAccount.account_type = "checking";
    	bankAccount.save();
    	assertNotNull(bankAccount.href);
        String href = bankAccount.href;
        bankAccount.unstore();
        // TODO: make sure this was deleted
    }

    @Test
    public void testBankAccountResourceFields() throws HTTPError {
        Map<String, Object> payload = personCustomerPayload();
        Customer customer = new Customer(payload);
        customer.save();

        BankAccount bankAccount = new BankAccount();
        bankAccount.name = "Harry Fakester";
        bankAccount.routing_number = "121042882";
        bankAccount.account_number = "112233a";
        bankAccount.account_type = "checking";
        bankAccount.save();

        bankAccount.associateToCustomer(customer);

        Map<String, String> meta = new HashMap<String, String>();
        meta.put("facebook", "0192837465");
        bankAccount.meta = meta;
        bankAccount.save();

        assertEquals(bankAccount.customer.href, customer.href);
        assertEquals(bankAccount.account_number, "xxx233a");
        assertEquals(bankAccount.account_type, "checking");
        assertEquals(bankAccount.address.toString(), "{city=null, line2=null, " +
                "line1=null, state=null, postal_code=null, country_code=null}");
        assertEquals(bankAccount.bank_name, "WELLS FARGO BANK NA");
        assertTrue(bankAccount.can_credit);
        assertFalse(bankAccount.can_debit);
        assertNotNull(bankAccount.created_at);
        assertNotNull(bankAccount.fingerprint);
        assertTrue(bankAccount.href.contains("/bank_accounts/BA"));
        assertTrue(bankAccount.id.contains("BA"));
        assertTrue(bankAccount.links.containsKey("customer"));
        assertTrue(bankAccount.links.containsKey("bank_account_verification"));
        assertEquals(bankAccount.meta.get("facebook"), "0192837465");
        assertEquals(bankAccount.name, "Harry Fakester");
        assertEquals(bankAccount.routing_number, "121042882");
        assertNotNull(bankAccount.updated_at);
        assertTrue((bankAccount.verifications.toString()).contains(
                "com.balancedpayments.BankAccountVerification$Collection"));
        assertNull(bankAccount.verification);
        assertThat(bankAccount.credits, instanceOf(Credit.Collection.class));
        assertThat(bankAccount.debits, instanceOf(Debit.Collection.class));
        assertEquals(bankAccount.bank_name, "WELLS FARGO BANK NA");
    }
}