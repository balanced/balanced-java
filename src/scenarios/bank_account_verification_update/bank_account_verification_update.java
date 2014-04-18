package bank_account_verification_update;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class bank_account_verification_update {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-1ByQgRpcQLTwmOhCBUofyIHm0r96qPm8s");

BankAccountVerification verification = new BankAccountVerification("/verifications/BZ2AZ05mk2SQsEcicjSh3UN");
try {
    verification.confirm(1, 1);
}
catch (HTTPError e) {}

}
}

