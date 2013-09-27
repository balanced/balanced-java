package bank_account_verification_create;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class bank_account_verification_create {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("71d76c1223ad11e38848026ba7c1aba6");

BankAccount bankAccount = new BankAccount("/v1/bank_accounts/BA3RqCmyIJC7MqeMggO9mF3G");
bankAccount.verify();

}
}

