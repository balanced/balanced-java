package hold_void;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class hold_void {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-2ppXve1BnInnsIKZytspDrsuhjtAT9dD8");

Hold hold = new Hold("/v1/marketplaces/TEST-MP2YQknCUwTrp3NiNxuqDEpi/holds/HL5iWt515DkeIqg2UJq778qS");
hold.is_void = true;
hold.save();

}
}

