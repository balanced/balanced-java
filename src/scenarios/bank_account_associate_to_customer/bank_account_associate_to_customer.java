package bank_account_associate_to_customer;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class bank_account_associate_to_customer {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-2fYjkv4Tz5l3iPCtOlgLolmF15XPXlRCr");

Customer customer = new Customer("/customers/CUb38G1IRIovbbaJlMMKUqG");
BankAccount bankAccount = new BankAccount("/bank_accounts/BAd2UKqX83C1p7fhmMx5pmW");

bankAccount.associateToCustomer(customer);

}
}

