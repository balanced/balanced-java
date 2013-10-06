% if mode == 'definition':
Account.promoteToMerchant(Map<String, Object> payload)

% else:
Balanced.configure("ak-test-1p1Tsac7gHeMQowL2seB7ieliuAJAufyq");

Account account = new Account("/v1/marketplaces/TEST-MP5FKPQwyjvVgTDt7EiRw3Kq/accounts");
Map<String, Object> merchantPayload = new HashMap<String, Object>();
Map<String, Object> personPayload = new HashMap<String, Object>();

merchantPayload.put("name", "Timmy Q. CopyPasta");
merchantPayload.put("dob", "1989-12");
merchantPayload.put("phone_number", "+14089999999");
merchantPayload.put("postal_code", "94110");
merchantPayload.put("street_address", "121 Skriptkid Row");
merchantPayload.put("type", "person");

account.promoteToMerchant(merchantPayload);

% endif

