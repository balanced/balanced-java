package credit_show;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class credit_show {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("71d76c1223ad11e38848026ba7c1aba6");

Credit credit = new Credit("/v1/marketplaces/TEST-MP3t1UYs4ixXWfZ79kXhEUcy/credits/CR4mdwJXFWJDuVuFi7WOzTig");

}
}

