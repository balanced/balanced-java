package hold_update;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class hold_update {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Settings.configure("71d76c1223ad11e38848026ba7c1aba6");

Hold hold = new Hold("/v1/marketplaces/TEST-MP3t1UYs4ixXWfZ79kXhEUcy/holds/HL5iaMpKeWTH4nMWYyItmOZy");
hold.description = "update this description";
hold.save();

}
}
