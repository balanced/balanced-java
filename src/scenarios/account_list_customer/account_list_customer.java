package account_list_customer;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class account_list_customer {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-2wIOi20ITgc1u1Lw6UM3y5ZZjZ66M8HMf");

Customer customer = new Customer("/customers/CU6sIkS1KUtHVoPUBM1Gf72B");
Account.Collection accounts = customer.accounts;

}
}

