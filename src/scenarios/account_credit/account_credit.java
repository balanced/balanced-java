package account_credit;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class account_credit {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-2eKlj1ZDfAcZSARMf3NMhBHywDej0avSY");

Account account = new Account("/accounts/AT3ogJE07IErLJYR510QO6sM");

HashMap<String, Object> payload = new HashMap<String, Object>();
payload.put("amount", 1000);
payload.put("appears_on_statement_as", "ThingsCo");
payload.put("description", "A simple credit");
payload.put("order", "/orders/OR3vURGwVtqDnnkRS9fgH41G");

try {
    Credit credit = account.credit(payload);
}
catch (HTTPError e) {}

}
}

