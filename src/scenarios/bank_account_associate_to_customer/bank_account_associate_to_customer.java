package bank_account_associate_to_customer;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class bank_account_associate_to_customer {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-22IOkhevjZlmRP2do6CZixkkDshTiOjTV");

Customer customer = new Customer("/customers/CU3VYCUIfwngJsidJWdGw2W5");
BankAccount bankAccount = new BankAccount("/bank_accounts/BA3Y63fK5STwlhKNMkE3Utmd");

bankAccount.associateToCustomer(customer);

}
}

