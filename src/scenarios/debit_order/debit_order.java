package debit_order;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class debit_order {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-2eKlj1ZDfAcZSARMf3NMhBHywDej0avSY");

Card card = new Card("/cards/CC4zyuNpxY0A0eAf87SeULCR");
Order order = new Order("/orders/OR3vURGwVtqDnnkRS9fgH41G");

HashMap<String, Object> payload = new HashMap<String, Object>();
payload.put("amount", 5000);

try {
    Debit debit = order.debitFrom(card, payload);
}
catch (HTTPError e) {}

}
}

