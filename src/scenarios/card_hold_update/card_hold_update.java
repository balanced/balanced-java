package card_hold_update;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class card_hold_update {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-2fYjkv4Tz5l3iPCtOlgLolmF15XPXlRCr");

CardHold cardHold = new CardHold("/card_holds/HLbr4hg4i7Mg2wAEroOwJhk");
cardHold.description = "update this description";
try {
    cardHold.save();
}
catch (HTTPError e) {}

}
}

