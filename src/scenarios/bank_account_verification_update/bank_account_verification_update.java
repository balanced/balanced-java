package bank_account_verification_update;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class bank_account_verification_update {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-25ZY8HQwZPuQtDecrxb671LilUya5t5G0");

BankAccountVerification verification = new BankAccountVerification("/verifications/BZ1eMAsKt13lIj2SkvvHlxfT");
try {
    verification.confirm(1, 1);
}
catch (HTTPError e) {}

}
}

