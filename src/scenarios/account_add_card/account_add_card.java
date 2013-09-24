package account_add_card;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class account_add_card {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Settings.configure("71d76c1223ad11e38848026ba7c1aba6");

Account account = new Account("/v1/marketplaces/TEST-MP3t1UYs4ixXWfZ79kXhEUcy/accounts/CU3DVmB4y4VJnHcb6X9qnSnS");
account.associateCard("/v1/marketplaces/TEST-MP3t1UYs4ixXWfZ79kXhEUcy/cards/CC3G4m4IFSShCmYZXyWRTM7g");

}
}
