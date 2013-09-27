package bank_account_verification_update;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class bank_account_verification_update {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("71d76c1223ad11e38848026ba7c1aba6");

BankAccountVerification verification = new BankAccountVerification("/v1/bank_accounts/BA3YXRiVoKoMJMhq3Bfwxyu2/verifications/BZ40XvdMDOfXN0T7fIlFF4U8");
verification.confirm(1, 1);
verification.save();

}
}

