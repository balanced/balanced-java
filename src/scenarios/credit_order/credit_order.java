package credit_order;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class credit_order {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-aUV295IugdhWSNx2JFckYBCSvfY2ibgq");

BankAccount bankAccount = new BankAccount("/bank_accounts/BA1BnM6LmT9DLV4bZDIjUmHD");
Order order = new Order("/orders/OR1s2WQKp0shLH9Qb0LiUfEJ");

HashMap<String, Object> payload = new HashMap<String, Object>();
payload.put("amount", 5000);

try {
    Credit credit = order.creditTo(bankAccount, payload);
}
catch (HTTPError e) {}

}
}

