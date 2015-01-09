package bank_account_associate_to_customer;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class bank_account_associate_to_customer {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-1xLFE6RLC1W3P4ePiQDI4UVpRwtKcdfqL");

Customer customer = new Customer("/customers/CU4CZc7Xjn8gGJXl1LyzZk7S");
BankAccount bankAccount = new BankAccount("/bank_accounts/BA6g0aWJb8TNd7sXXs17t0Q0");

bankAccount.associateToCustomer(customer);

}
}

