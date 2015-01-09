package card_hold_update;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class card_hold_update {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-1xLFE6RLC1W3P4ePiQDI4UVpRwtKcdfqL");

CardHold cardHold = new CardHold("/card_holds/HL44qbPoom3uVlTlEGBZV7z2");
cardHold.description = "update this description";
try {
    cardHold.save();
}
catch (HTTPError e) {}

}
}

