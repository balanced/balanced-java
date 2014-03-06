package bank_account_credit;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class bank_account_credit {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-2cSDy37BKy5K4NUHKHVNXNTjTHPEqjRtB");

BankAccount bankAccount = new BankAccount("/bank_accounts/BA4JCiiAb4alhWMlZSv9POAU/credits");

HashMap<String, Object> payload = new HashMap<String, Object>();
payload.put("amount", 5000);

Credit credit = bankAccount.credit(payload);

}
}

