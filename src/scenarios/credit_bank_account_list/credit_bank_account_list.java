package credit_bank_account_list;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class credit_bank_account_list {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-1p1Tsac7gHeMQowL2seB7ieliuAJAufyq");

BankAccount bankAccount = new BankAccount("/v1/bank_accounts/BA6wDj2MwJTwkPA4s4rEMq2y");
Credit.Collection credits = bankAccount.credits;

}
}

