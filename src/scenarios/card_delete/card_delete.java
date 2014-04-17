package card_delete;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class card_delete {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-2fYjkv4Tz5l3iPCtOlgLolmF15XPXlRCr");

Card card = new Card("/cards/CCA3crun7LbUPTtQyJhPAtW");
try {
    card.unstore();
}
catch (HTTPError e) {}
catch (NotCreated e) {}

}
}

