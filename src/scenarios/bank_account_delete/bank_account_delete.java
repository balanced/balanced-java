package bank_account_delete;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class bank_account_delete {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-1ByQgRpcQLTwmOhCBUofyIHm0r96qPm8s");

BankAccount bankAccount = new BankAccount("/bank_accounts/BA8MzVwjVFnkuUvfHaXmqMZ");
try {
    bankAccount.unstore();
}
catch (APIError e) {}
catch (NotCreated e) {}

}
}

