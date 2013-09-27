package hold_void;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class hold_void {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("71d76c1223ad11e38848026ba7c1aba6");

Hold hold = new Hold("/v1/marketplaces/TEST-MP3t1UYs4ixXWfZ79kXhEUcy/holds/HL5yeuNhpim4hq0nci5Zty2e");
hold.is_void = true;
hold.save();

}
}

