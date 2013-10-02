% if mode == 'definition':
Hold.capture(Map<String, Object> payload);

% else:
Settings.configure("c07a8282f49111e2a035026ba7d31e6f");

Map<String, Object> payload = new HashMap<String, Object>();
payload.put("hold_uri", "/v1/marketplaces/TEST-MP5Rwi1N0GqQZ9nAyf11c2v0/holds/HL7Cb8oN0OKc7Fjfm0twx65Q");
payload.put("amount", 1000);
Hold hold = new Hold(payload);
hold.account_uri = "/v1/marketplaces/TEST-MP5Rwi1N0GqQZ9nAyf11c2v0/accounts/AC7uvsGvRVwgII1TwvbgKakU";
Account account = hold.getAccount();
Debit debit = hold.capture(1000);

% endif

