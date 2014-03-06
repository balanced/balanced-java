package card_hold_update;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;

public class hold_update {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-1kvvievk0Qqw5wQPsrlM9g7wQwNe62cyc");

CardHold cardHold = new CardHold("");
cardHold.description = "";
cardHold.save();

}
}

