package customer_add_bank_account;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class customer_add_bank_account {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Settings.configure("71d76c1223ad11e38848026ba7c1aba6");

Customer customer = new Customer("/v1/customers/CU4GE2VH7Fk1sVykRogtFKyI");
customer.addBankAccount("/v1/bank_accounts/BA4HRfPO4i6y7bcUinjtyK1i");

}
}
