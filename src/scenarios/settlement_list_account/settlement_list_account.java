package settlement_list_account;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class settlement_list_account {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-1xLFE6RLC1W3P4ePiQDI4UVpRwtKcdfqL");

Account account = new Account("/accounts/AT2E6Ju62P9AnTJwe0fL5kOI");
Settlement.Collection settlements = account.settlements;

}
}

