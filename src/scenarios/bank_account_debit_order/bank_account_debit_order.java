package bank_account_debit_order;

import com.balancedpayments.Balanced;
import com.balancedpayments.BankAccount;
import com.balancedpayments.Debit;
import com.balancedpayments.Order;
import com.balancedpayments.errors.HTTPError;
import com.balancedpayments.errors.MultipleResultsFound;
import com.balancedpayments.errors.NoResultsFound;

import java.util.HashMap;

public class bank_account_debit_order {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-25ZY8HQwZPuQtDecrxb671LilUya5t5G0");

BankAccount bankAccount = new BankAccount("/bank_accounts/BA17zYxBNrmg9isvicjz9Ae4");
Order order = new Order("/orders/OR5sl2RJVnbwEf45nq5eATdz");

HashMap<String, Object> payload = new HashMap<String, Object>();
payload.put("amount", 5000);

try {
    Debit debit = order.debitFrom(bankAccount, payload);
}
catch (HTTPError e) {}

}
}

