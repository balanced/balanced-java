package card_delete;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class card_delete {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-25ZY8HQwZPuQtDecrxb671LilUya5t5G0");

Card card = new Card("/cards/CC33DRVrekWpiHYjxSdVuqWc");
try {
    card.unstore();
}
catch (HTTPError e) {}
catch (NotCreated e) {}

}
}

