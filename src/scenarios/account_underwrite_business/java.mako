% if mode == 'definition':
Account.promoteToMerchant(Map<String, Object> payload)

% else:
Balanced.configure("ak-test-2ppXve1BnInnsIKZytspDrsuhjtAT9dD8");

Account account = new Account("/v1/marketplaces/TEST-MP2YQknCUwTrp3NiNxuqDEpi/accounts");
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

% endif

