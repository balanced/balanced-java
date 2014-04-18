package bank_account_associate_to_customer;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class bank_account_associate_to_customer {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-1ByQgRpcQLTwmOhCBUofyIHm0r96qPm8s");

Customer customer = new Customer("/customers/CUeXNjpejPooRtSnJLc6SRD");
BankAccount bankAccount = new BankAccount("/bank_accounts/BAscOV2erMwv3yhIb5sFTaV");

bankAccount.associateToCustomer(customer);

}
}

