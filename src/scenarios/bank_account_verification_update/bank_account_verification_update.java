package bank_account_verification_update;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class bank_account_verification_update {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-22IOkhevjZlmRP2do6CZixkkDshTiOjTV");

BankAccountVerification verification = new BankAccountVerification("/verifications/BZ3KkIZuSazKfqFrFIfsrhmB");
try {
    verification.confirm(1, 1);
}
catch (HTTPError e) {}

}
}

