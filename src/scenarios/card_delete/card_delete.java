package card_delete;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class card_delete {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-2eKlj1ZDfAcZSARMf3NMhBHywDej0avSY");

Card card = new Card("/cards/CC4zyuNpxY0A0eAf87SeULCR");
try {
    card.unstore();
}
catch (HTTPError e) {}
catch (NotCreated e) {}

}
}

