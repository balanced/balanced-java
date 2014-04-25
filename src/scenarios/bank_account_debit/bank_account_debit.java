package bank_account_debit;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class bank_account_debit {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-22IOkhevjZlmRP2do6CZixkkDshTiOjTV");

BankAccount bankAccount = new BankAccount("/bank_accounts/BA3IhKG3bIN22cLHbaOIGtHb");

HashMap<String, Object> payload = new HashMap<String, Object>();
payload.put("amount", 5000);
payload.put("description", "Some descriptive text for the debit in the dashboard");
payload.put("appears_on_statement_as", "Statement text");

try {
    Debit debit = bankAccount.debit(payload);
}
catch (HTTPError e) {}

}
}

