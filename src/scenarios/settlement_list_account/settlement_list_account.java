package settlement_list_account;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class settlement_list_account {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-2eKlj1ZDfAcZSARMf3NMhBHywDej0avSY");

Account account = new Account("/accounts/AT3ogJE07IErLJYR510QO6sM");
Settlement.Collection settlements = account.settlements;

}
}

