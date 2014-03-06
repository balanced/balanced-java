package card_delete;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class card_delete {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-2cSDy37BKy5K4NUHKHVNXNTjTHPEqjRtB");

Card card = new Card("/cards/CC4cbNzUmFqGrc1GmFpXp6fe");
try {
    card.unstore();
}
catch (HTTPError e) {}
catch (NotCreated e) {}

}
}

