package card_invalidate;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class card_invalidate {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-2ppXve1BnInnsIKZytspDrsuhjtAT9dD8");

Card card = new Card("/v1/marketplaces/TEST-MP2YQknCUwTrp3NiNxuqDEpi/cards/CC3Nm7MZZgDfqOKGyZ5cu9eM");

try {
    card.unstore();
}
catch (NotCreated e) {
    // card never existed
}

}
}

