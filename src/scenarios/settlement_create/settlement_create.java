package settlement_create;

import com.balancedpayments.Account;
import com.balancedpayments.Balanced;
import com.balancedpayments.Settlement;
import com.balancedpayments.errors.HTTPError;
import com.balancedpayments.errors.MultipleResultsFound;
import com.balancedpayments.errors.NoResultsFound;

import java.util.HashMap;

public class settlement_create {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-1xLFE6RLC1W3P4ePiQDI4UVpRwtKcdfqL");

Account account = new Account("/accounts/AT2E6Ju62P9AnTJwe0fL5kOI");

HashMap<String, Object> payload = new HashMap<String, Object>();
payload.put("funding_instrument", "/bank_accounts/BA3uzbngfVXy1SGg25Et7iKY");
payload.put("appears_on_statement_as", "ThingsCo");
payload.put("description", "Payout A");

try {
    Settlement settlement = account.settle(payload);
}
catch (HTTPError e) {}

}
}

