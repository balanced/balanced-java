package card_hold_update;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class card_hold_update {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-1ByQgRpcQLTwmOhCBUofyIHm0r96qPm8s");

CardHold cardHold = new CardHold("/card_holds/HLqY5FcrUWcnBzMkHpKK1WB");
cardHold.description = "update this description";
try {
    cardHold.save();
}
catch (HTTPError e) {}

}
}

