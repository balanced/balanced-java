% if mode == 'definition':
Account.promoteToMerchant(Map<String, Object> payload);

% else:
Settings.configure("c07a8282f49111e2a035026ba7d31e6f");

Account account = new Account("/v1/marketplaces/TEST-MP5Rwi1N0GqQZ9nAyf11c2v0/accounts");
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

