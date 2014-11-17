package card_associate_to_customer;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class card_associate_to_customer {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-25ZY8HQwZPuQtDecrxb671LilUya5t5G0");

Customer customer = new Customer("");
Card card = new Card("/cards/CC3IBNr3erYpVuuZDyWNFfet");

try {
    card.associateToCustomer(customer);
}
catch (HTTPError e) {}

}
}

