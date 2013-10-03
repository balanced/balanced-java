package bank_account_verification_show;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class bank_account_verification_show {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-2ppXve1BnInnsIKZytspDrsuhjtAT9dD8");

BankAccountVerification verification = new BankAccountVerification("/v1/bank_accounts/BA3xjOoH07QriERLYAU4MWRE/verifications/BZ3zL5PzZeGn22qM4Um8rZF6");

}
}

