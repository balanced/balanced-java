package bank_account_verification_show;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class bank_account_verification_show {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Settings.configure("71d76c1223ad11e38848026ba7c1aba6");

BankAccountVerification verification = new BankAccountVerification("/v1/bank_accounts/BA3UJktegv9onsV0b4FJ50Eo/verifications/BZ3WAOvJeY9A45e3iYz1EAxG");

}
}
