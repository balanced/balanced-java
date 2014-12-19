package bank_account_associate_to_customer;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class bank_account_associate_to_customer {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-2wIOi20ITgc1u1Lw6UM3y5ZZjZ66M8HMf");

Customer customer = new Customer("/customers/CU42QGL6X08UHbQnRqgCNtKg");
BankAccount bankAccount = new BankAccount("/bank_accounts/BA4UZsYXpf2BX97v5WPaT57O");

bankAccount.associateToCustomer(customer);

}
}

