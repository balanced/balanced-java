package bank_account_verification_create;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class bank_account_verification_create {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-2wIOi20ITgc1u1Lw6UM3y5ZZjZ66M8HMf");

BankAccount bankAccount = new BankAccount("/bank_accounts/BA4plzFRTGgaoZftGcIJH3Py");
try {
    bankAccount.verify();
}
catch (HTTPError e) {}

}
}

