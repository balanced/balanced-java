package bank_account_verification_update;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class bank_account_verification_update {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-2fYjkv4Tz5l3iPCtOlgLolmF15XPXlRCr");

BankAccountVerification verification = new BankAccountVerification("/verifications/BZ7zjJJJqb1VU633qQw0z1Vc");
try {
    verification.confirm(1, 1);
}
catch (HTTPError e) {}

}
}

