% if mode == 'definition':
Account.promoteToMerchant(Map<String, Object> payload)

% else:
Balanced.configure("ak-test-2ppXve1BnInnsIKZytspDrsuhjtAT9dD8");

Account account = new Account("/v1/marketplaces/TEST-MP2YQknCUwTrp3NiNxuqDEpi/accounts");
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

