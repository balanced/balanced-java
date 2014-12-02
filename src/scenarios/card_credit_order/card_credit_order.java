package card_credit_order;

import com.balancedpayments.Balanced;
import com.balancedpayments.Card;
import com.balancedpayments.Credit;
import com.balancedpayments.Order;
import com.balancedpayments.errors.FundingInstrumentNotCreditable;
import com.balancedpayments.errors.HTTPError;
import com.balancedpayments.errors.MultipleResultsFound;
import com.balancedpayments.errors.NoResultsFound;

import java.util.HashMap;

public class card_credit_order {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-25ZY8HQwZPuQtDecrxb671LilUya5t5G0");

Card card = new Card("/cards/CC3IBNr3erYpVuuZDyWNFfet");
Order order = new Order("/orders/OR2UWXCNY2nKlqIQhQhWN3Jm");

HashMap<String, Object> payload = new HashMap<String, Object>();
payload.put("amount", 5000);

try {
    Credit credit = order.creditTo(card, payload);
}
catch (FundingInstrumentNotCreditable e) {}

}
}

