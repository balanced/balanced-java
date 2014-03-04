package hold_void;

import com.balancedpayments.CardHold;

public class hold_void {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-1p1Tsac7gHeMQowL2seB7ieliuAJAufyq");

CardHold cardHold = new CardHold("/v1/marketplaces/TEST-MP5FKPQwyjvVgTDt7EiRw3Kq/holds/HLz4ihqQhojMB0z17ZPxDXI");
cardHold.is_void = true;
cardHold.save();

}
}

