package hold_update;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class hold_update {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-2ppXve1BnInnsIKZytspDrsuhjtAT9dD8");

Hold hold = new Hold("/v1/marketplaces/TEST-MP2YQknCUwTrp3NiNxuqDEpi/holds/HL52kZFtZTaaxBfENP6l6y48");
hold.description = "update this description";
hold.save();

}
}

