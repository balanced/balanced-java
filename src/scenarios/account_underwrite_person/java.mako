% if mode == 'definition':
Account.promoteToMerchant(Map<String, Object> payload);

% else:
Balanced.configure("71d76c1223ad11e38848026ba7c1aba6");

Account account = new Account("/v1/marketplaces/TEST-MP3t1UYs4ixXWfZ79kXhEUcy/accounts");
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

