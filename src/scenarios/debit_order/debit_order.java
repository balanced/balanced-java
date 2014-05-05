package debit_order;

import com.balancedpayments.Balanced;
import com.balancedpayments.Card;
import com.balancedpayments.Debit;
import com.balancedpayments.Order;
import com.balancedpayments.errors.HTTPError;
import com.balancedpayments.errors.MultipleResultsFound;
import com.balancedpayments.errors.NoResultsFound;

import java.util.HashMap;

public class debit_order {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-aUV295IugdhWSNx2JFckYBCSvfY2ibgq");

Card card = new Card("/cards/CC5OD6648yiKfSzfj6z6MdXr");
Order order = new Order("/orders/OR5QcYnwysJXQswImokq6ZSx");

HashMap<String, Object> payload = new HashMap<String, Object>();
payload.put("amount", 5000);

try {
    Debit debit = order.debitFrom(card, payload);
}
catch (HTTPError e) {}

}
}

