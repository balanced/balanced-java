package bank_account_verification_create;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class bank_account_verification_create {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-1ByQgRpcQLTwmOhCBUofyIHm0r96qPm8s");

BankAccount bankAccount = new BankAccount("/bank_accounts/BAcRGk40xmI8meZpNLB3oYp");
try {
    bankAccount.verify();
}
catch (HTTPError e) {}

}
}

