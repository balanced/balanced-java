package card_delete;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class card_delete {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-2wIOi20ITgc1u1Lw6UM3y5ZZjZ66M8HMf");

Card card = new Card("/cards/CC5zxUdioIB0Dc2rjM1PK3Cw");
try {
    card.unstore();
}
catch (HTTPError e) {}
catch (NotCreated e) {}

}
}

