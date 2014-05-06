package credit_order;

import com.balancedpayments.Balanced;
import com.balancedpayments.BankAccount;
import com.balancedpayments.Credit;
import com.balancedpayments.Order;
import com.balancedpayments.errors.HTTPError;
import com.balancedpayments.errors.MultipleResultsFound;
import com.balancedpayments.errors.NoResultsFound;

import java.util.HashMap;

public class credit_order {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-aUV295IugdhWSNx2JFckYBCSvfY2ibgq");

BankAccount bankAccount = new BankAccount("/bank_accounts/BA5KLH6jhFgtVENHXOcF3Cfj/credits");
Order order = new Order("/orders/OR5QcYnwysJXQswImokq6ZSx");

HashMap<String, Object> payload = new HashMap<String, Object>();
payload.put("amount", 5000);

try {
    Credit credit = order.creditTo(bankAccount, payload);
}
catch (HTTPError e) {}

}
}

