package credit_failed_state;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class credit_failed_state {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Settings.configure("71d76c1223ad11e38848026ba7c1aba6");

BankAccount ba = new BankAccount();
ba.account_number = "";
ba.name = "";
ba.routing_number = "";
ba.type = "";
ba.save();
ba.credit();

}
}
