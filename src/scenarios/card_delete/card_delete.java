package card_delete;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class card_delete {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Settings.configure("71d76c1223ad11e38848026ba7c1aba6");

Card card = new Card("/v1/marketplaces/TEST-MP3t1UYs4ixXWfZ79kXhEUcy/cards/CC4bOqdUBsBenWu7klU6Qfzq");
try {
    card.unstore();
}
catch (NotCreated e) {
    // the card didn't exist in the first place
}

}
}
