package bank_account_associate_to_customer;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class bank_account_associate_to_customer {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-25ZY8HQwZPuQtDecrxb671LilUya5t5G0");

Customer customer = new Customer("/customers/CU2718cI8PkMdFyPjboZLZfn");
BankAccount bankAccount = new BankAccount("/bank_accounts/BA2gul8YMjFWnFk0fFHXwX6g");

bankAccount.associateToCustomer(customer);

}
}

