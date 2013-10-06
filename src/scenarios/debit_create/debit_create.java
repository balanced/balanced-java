package debit_create;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class debit_create {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-1p1Tsac7gHeMQowL2seB7ieliuAJAufyq");

Account account = new Account("");
account.debit(5000,
              "Some descriptive text for the debit in the dashboard",
              "",
              "Statement text",
              null);

}
}

