package bank_account_verification_update;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class bank_account_verification_update {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-2ppXve1BnInnsIKZytspDrsuhjtAT9dD8");

BankAccountVerification verification = new BankAccountVerification("/v1/bank_accounts/BA3Cc1WHeLCM0GhP6havpp7N/verifications/BZ3ErxujTs0WxUs2EiMMtre7");
verification.confirm(1, 1);
verification.save();

}
}

