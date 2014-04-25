package bank_account_update;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class bank_account_update {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-22IOkhevjZlmRP2do6CZixkkDshTiOjTV");

BankAccount bankAccount = new BankAccount("/bank_accounts/BA3PDwDCkdeC4OgPtPNwoCWl");

Map<String, String> meta = new HashMap<String, String>();
meta.put("facebook.user_id", "0192837465");
meta.put("my-own-customer-id", "12345");
meta.put("twitter.id", "1234987650");

bankAccount.meta = meta;

try {
    bankAccount.save();
}
catch (HTTPError e) {}



}
}

