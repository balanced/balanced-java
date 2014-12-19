package bank_account_verification_update;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class bank_account_verification_update {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-2wIOi20ITgc1u1Lw6UM3y5ZZjZ66M8HMf");

BankAccountVerification verification = new BankAccountVerification("/verifications/BZ4x3kqJ5rTrM8LL0WmP4GUZ");
try {
    verification.confirm(1, 1);
}
catch (HTTPError e) {}

}
}

