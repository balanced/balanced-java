package bank_account_verification_show;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class bank_account_verification_show {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-1p1Tsac7gHeMQowL2seB7ieliuAJAufyq");

BankAccountVerification verification = new BankAccountVerification("/v1/bank_accounts/BA6jdVg9pWO5ePNdL8ucclXi/verifications/BZ6lvRngcv6BuAu5m5XZAx8A");

}
}

