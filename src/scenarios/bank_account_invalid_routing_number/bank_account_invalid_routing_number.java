package bank_account_invalid_routing_number;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class bank_account_invalid_routing_number {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("71d76c1223ad11e38848026ba7c1aba6");

BankAccount ba = new BankAccount("/v1/marketplaces/TEST-MP3t1UYs4ixXWfZ79kXhEUcy/bank_accounts");
ba.account_number = "9900000001";
ba.routing_number = "111111118";
ba.name = "Johann Bernoulli";
ba.type = "checking";
try {
    ba.save();
}
catch (HTTPError e) {
    // handle invalid routing numbers
}

}
}

