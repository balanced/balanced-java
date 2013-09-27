package refund_create;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class refund_create {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("71d76c1223ad11e38848026ba7c1aba6");

Debit debit = new Debit("/v1/marketplaces/TEST-MP3t1UYs4ixXWfZ79kXhEUcy/debits/WD5BFX0Rw4d97tjtNGNl0N0Q");
debit.refund();

}
}

