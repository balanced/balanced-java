package card_charge;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class card_charge {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound, CardUnassociated {
Settings.configure("2776ea40d92e11e29fe1026ba7cac9da");

Map<String, Object> payload = new HashMap<String, Object>();
payload.put("card_number", "");
payload.put("security_code", "");
Card card = new Card(payload);
card.save();

Customer customer = new Customer();
customer.addCard(card);
card.refresh();
card.debit(10000);


}
}

