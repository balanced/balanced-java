package card_hold_void;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class card_hold_void {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-2wIOi20ITgc1u1Lw6UM3y5ZZjZ66M8HMf");

CardHold cardHold = new CardHold("/card_holds/HL5usZqQ94C25Cv0kmFDJYZD");
try {
    cardHold.unstore();
}
catch (HTTPError e) {}
catch (NotCreated notCreated) {}

}
}

