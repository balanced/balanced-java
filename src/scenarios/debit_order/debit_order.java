package debit_order;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class debit_order {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-2wIOi20ITgc1u1Lw6UM3y5ZZjZ66M8HMf");

Card card = new Card("/cards/CC5zxUdioIB0Dc2rjM1PK3Cw");
Order order = new Order("/orders/OR483MoeOnJEXwkxqoPdnDF3");

HashMap<String, Object> payload = new HashMap<String, Object>();
payload.put("amount", 5000);

try {
    Debit debit = order.debitFrom(card, payload);
}
catch (HTTPError e) {}

}
}

