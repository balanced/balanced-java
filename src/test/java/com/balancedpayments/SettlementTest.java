package com.balancedpayments;

import com.balancedpayments.errors.HTTPError;
import com.balancedpayments.errors.MultipleResultsFound;
import com.balancedpayments.errors.NoResultsFound;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class SettlementTest extends BaseTest {
    @Test
    public void testSettlement() throws HTTPError, MultipleResultsFound,
            NoResultsFound {
        Customer merchant = createPersonCustomer();
        Account payable_account = merchant.payable_account();


        BankAccount ba = createBankAccount();
        ba.associateToCustomer(merchant);
        Order order = merchant.createOrder(null);
        Card card = createCard();

        Map<String, Object> debitPayload = new HashMap<String, Object>();
        debitPayload.put("description", "Debit for Order #234123");
        debitPayload.put("amount", 5000);

        Debit debit = order.debitFrom(card, debitPayload);
        order.reload();

        Map<String, Object> creditPayload = new HashMap<String, Object>();
        creditPayload.put("description", "Payout for Order #234123");
        creditPayload.put("amount", 5000);
        creditPayload.put("order", order.href);

        Credit credit = payable_account.credit(creditPayload);

        Map<String, Object> settlementPayload = new HashMap<String, Object>();
        settlementPayload.put("funding_instrument", ba.href);
        settlementPayload.put("appears_on_statement_as", "Oct Settlement");

        Settlement settlement =  payable_account.settle(settlementPayload);
        payable_account.reload();

        assertEquals(payable_account.balance.intValue(), 0);
        assertEquals(settlement.amount.intValue(), 5000);
    }

    @Test
    public void testReverseSettlement() throws HTTPError, MultipleResultsFound,
            NoResultsFound {
        Customer merchant = createPersonCustomer();
        Account payable_account = merchant.payable_account();


        BankAccount ba = createBankAccount();
        ba.associateToCustomer(merchant);
        Order order = merchant.createOrder(null);
        Card card = createCard();

        Map<String, Object> debitPayload = new HashMap<String, Object>();
        debitPayload.put("description", "Debit for Order #234123");
        debitPayload.put("amount", 5000);

        Debit debit = order.debitFrom(card, debitPayload);
        order.reload();

        Map<String, Object> creditPayload = new HashMap<String, Object>();
        creditPayload.put("description", "Payout for Order #234123");
        creditPayload.put("amount", 5000);
        creditPayload.put("order", order.href);

        Credit credit = payable_account.credit(creditPayload);

        Map<String, Object> settlementPayload = new HashMap<String, Object>();
        settlementPayload.put("funding_instrument", ba.href);
        settlementPayload.put("appears_on_statement_as", "Oct Settlement");

        Settlement settlement =  payable_account.settle(settlementPayload);
        payable_account.reload();


        Order order_two = merchant.createOrder(null);

        Map<String, Object> debitTwoPayload = new HashMap<String, Object>();
        debitTwoPayload.put("description", "Debit for Order #234123");
        debitTwoPayload.put("amount", 5000);

        Debit debit_two = order_two.debitFrom(card, debitTwoPayload);

        Map<String, Object> creditTwoPayload = new HashMap<String, Object>();
        creditTwoPayload.put("description", "Payout for Order #234123");
        creditTwoPayload.put("amount", 5000);
        creditTwoPayload.put("order", order_two.href);

        Credit credit_two = payable_account.credit(creditTwoPayload);
        payable_account.reload();
        assertEquals(payable_account.balance.intValue(), 5000);

        HashMap<String, Object> payload = new HashMap<String, Object>();
        payload.put("amount", 5000);
        credit.reverse(payload);

        payable_account.reload();
        assertEquals(payable_account.balance.intValue(), 0);
    }

    @Test
    public void testReverseSettlementWithNegativeBalance() throws HTTPError, MultipleResultsFound,
            NoResultsFound {
        Customer merchant = createPersonCustomer();
        Account payable_account = merchant.payable_account();

        BankAccount ba = createBankAccount();
        ba.associateToCustomer(merchant);
        Order order = merchant.createOrder(null);
        Card card = createCard();

        Map<String, Object> debitPayload = new HashMap<String, Object>();
        debitPayload.put("description", "Debit for Order #234123");
        debitPayload.put("amount", 5000);

        Debit debit = order.debitFrom(card, debitPayload);
        order.reload();

        Map<String, Object> creditPayload = new HashMap<String, Object>();
        creditPayload.put("description", "Payout for Order #234123");
        creditPayload.put("amount", 5000);
        creditPayload.put("order", order.href);

        Credit credit = payable_account.credit(creditPayload);

        Map<String, Object> settlementPayload = new HashMap<String, Object>();
        settlementPayload.put("funding_instrument", ba.href);
        settlementPayload.put("appears_on_statement_as", "Oct Settlement");

        Settlement settlement =  payable_account.settle(settlementPayload);
        payable_account.reload();

        HashMap<String, Object> payload = new HashMap<String, Object>();
        payload.put("amount", 5000);
        credit.reverse(payload);

        payable_account.reload();
        assertEquals(payable_account.balance.intValue(), -5000);

        Map<String, Object> settlementTwoPayload = new HashMap<String, Object>();
        settlementTwoPayload.put("funding_instrument", ba.href);
        settlementTwoPayload.put("appears_on_statement_as", "Oct Settlement");

        Settlement settlement_two =  payable_account.settle(settlementPayload);
        payable_account.reload();
        assertEquals(payable_account.balance.intValue(), 0);
    }
}