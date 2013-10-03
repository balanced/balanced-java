package com.balancedpayments;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import com.balancedpayments.errors.BankAccountVerificationFailure;
import com.balancedpayments.errors.CannotCreate;
import com.balancedpayments.errors.HTTPError;
import com.balancedpayments.errors.APIError;
import com.balancedpayments.errors.MultipleResultsFound;
import com.balancedpayments.errors.NoResultsFound;
import com.balancedpayments.errors.NotCreated;
import org.junit.rules.ExpectedException;

import java.util.HashMap;
import java.util.Map;

public class BankAccountTest  extends BaseTest {

    protected BankAccount ba;
    protected BankAccount ba2;

    @Rule
    public ExpectedException apiError = ExpectedException.none();

    @Override
    @Before
    public void setUp() throws NoResultsFound, MultipleResultsFound, HTTPError {
        super.setUp();
        Account account = mp.createAccount("Homer Jay");
        ba = createBankAccount(mp);
        ba2 = createBankAccount(mp);
        account.associateBankAccount(ba2.uri);
        account.associateBankAccount(ba.uri);
    }

    @Test
    public void testVerify() throws CannotCreate, HTTPError {
        BankAccountVerification bav = ba.verify();
        ba.reload();
        assertEquals(ba.getVerification().id, bav.id);
        bav.confirm(1, 1);
        assertEquals(bav.attempts.intValue(), 1);
        assertEquals(bav.state, "verified");
    }

    @Test(expected=BankAccountVerificationFailure.class)
    public void testDoubleVerify() throws CannotCreate, HTTPError {
        ba.verify();
        ba.verify();
    }

    @Test
    public void testUnstoreOfBankAccountFromAssociatedBankAccount() throws CannotCreate, HTTPError, NotCreated {
        assertEquals(ba.is_valid, true);
        Customer customer = createPersonCustomer();
        customer.addCard(createCard(mp).uri);

        Map<String, Object> debitPayload = new HashMap<String, Object>();
        debitPayload.put("amount", 100);
        customer.debit(debitPayload);

        Map<String, Object> creditPayload = new HashMap<String, Object>();
        creditPayload.put("amount", 100);
        ba.credit(creditPayload);
        ba.unstore();
        apiError.expect(APIError.class);
        ba.credit(creditPayload);
    }

    @Test
    public void testSofDeleteOfBankAccount() throws HTTPError{
    	BankAccount bankAccount = new BankAccount();
    	bankAccount.name = "Harry Fakester";
    	bankAccount.routing_number = "121042882";
    	bankAccount.account_number = "112233a";
    	bankAccount.type = "checking";
    	bankAccount.save();
    	assertEquals(bankAccount.is_valid, null);
    }
}
