package credit_failed_state;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class credit_failed_state {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-2ppXve1BnInnsIKZytspDrsuhjtAT9dD8");

BankAccount ba = new BankAccount();
ba.account_number = "";
ba.name = "";
ba.routing_number = "";
ba.type = "";
ba.save();
ba.credit();

}
}

