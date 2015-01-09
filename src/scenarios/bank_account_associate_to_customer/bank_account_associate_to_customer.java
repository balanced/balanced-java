package bank_account_associate_to_customer;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class bank_account_associate_to_customer {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-2eKlj1ZDfAcZSARMf3NMhBHywDej0avSY");

Customer customer = new Customer("/customers/CU3o1ZAd8Gtxz6ZTIFK9YmsM");
BankAccount bankAccount = new BankAccount("/bank_accounts/BA45anEaEr8g0lOhzhcE9VAN");

bankAccount.associateToCustomer(customer);

}
}

