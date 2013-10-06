package account_underwrite_business;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class account_underwrite_business {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-1p1Tsac7gHeMQowL2seB7ieliuAJAufyq");

Account account = new Account("/v1/marketplaces/TEST-MP5FKPQwyjvVgTDt7EiRw3Kq/accounts");
Map<String, Object> merchantPayload = new HashMap<String, Object>();
Map<String, Object> personPayload = new HashMap<String, Object>();

personPayload.put("dob", "1989-12");
personPayload.put("name", "Timmy Q. CopyPasta");
personPayload.put("phone_number", "+14089999999");
personPayload.put("postal_code", "94110");
personPayload.put("street_address", "121 Skriptkid Row");
merchantPayload.put("name", "Skripts4Kids");
merchantPayload.put("person", personPayload);
merchantPayload.put("phone_number", "+140899188155");
merchantPayload.put("postal_code", "91111");
merchantPayload.put("street_address", "555 VoidMain Road");
merchantPayload.put("tax_id", "211111111");
merchantPayload.put("type", "business");

account.promoteToMerchant(merchantPayload);

}
}

