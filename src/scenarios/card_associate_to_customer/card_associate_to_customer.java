package card_associate_to_customer;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class card_associate_to_customer {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-2fYjkv4Tz5l3iPCtOlgLolmF15XPXlRCr");

Customer customer = new Customer("");
Card card = new Card("/cards/CCHv1QwjLfCxskorXDf8bmm");

try {
    card.associateToCustomer(customer);
}
catch (HTTPError e) {}

}
}

