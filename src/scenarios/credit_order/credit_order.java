package credit_order;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class credit_order {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-2eKlj1ZDfAcZSARMf3NMhBHywDej0avSY");

BankAccount bankAccount = new BankAccount("/bank_accounts/BA45anEaEr8g0lOhzhcE9VAN/credits");
Order order = new Order("/orders/OR3vURGwVtqDnnkRS9fgH41G");

HashMap<String, Object> payload = new HashMap<String, Object>();
payload.put("amount", 5000);

try {
    Credit credit = order.creditTo(bankAccount, payload);
}
catch (HTTPError e) {}

}
}

