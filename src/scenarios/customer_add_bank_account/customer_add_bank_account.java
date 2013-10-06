package customer_add_bank_account;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class customer_add_bank_account {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-1p1Tsac7gHeMQowL2seB7ieliuAJAufyq");

Customer customer = new Customer("/v1/customers/CU7o5OSA8KuFSSjweE54NITe");
customer.addBankAccount("/v1/bank_accounts/BA7q1HxYvJr41fVUPk8vMrCm");

}
}

