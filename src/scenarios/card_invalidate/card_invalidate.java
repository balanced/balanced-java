package card_invalidate;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class card_invalidate {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-1p1Tsac7gHeMQowL2seB7ieliuAJAufyq");

Card card = new Card("/v1/marketplaces/TEST-MP5FKPQwyjvVgTDt7EiRw3Kq/cards/CC6NiW8huZV4AxYTDJsjOd7k");

try {
    card.unstore();
}
catch (NotCreated e) {
    // card never existed
}

}
}

