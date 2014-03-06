package credit_update;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class credit_update {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-2cSDy37BKy5K4NUHKHVNXNTjTHPEqjRtB");

Credit credit = new Credit("/credits/CR4wyLukORa0TXhCYtjZrfw5");

Map<String, String> meta = new HashMap<String, String>();
meta.put("facebook.id", "1234567890");
meta.put("anykey", "valuegoeshere");

credit.meta = meta;
credit.description = "New description for credit";

try {
    credit.save();
}
catch (HTTPError e) {}

}
}

