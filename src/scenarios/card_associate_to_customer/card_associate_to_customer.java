package card_associate_to_customer;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class card_associate_to_customer {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-2wIOi20ITgc1u1Lw6UM3y5ZZjZ66M8HMf");

Customer customer = new Customer("");
Card card = new Card("/cards/CC5OFIKHlTTxx8uysB8woICs");

try {
    card.associateToCustomer(customer);
}
catch (HTTPError e) {}

}
}

