% if mode == 'definition':
Card(Map<String, Object> payload)

% else:
Balanced.configure("ak-test-2ppXve1BnInnsIKZytspDrsuhjtAT9dD8");

Map<String, Object> payload = new HashMap<String, Object>();
payload.put("card_number", "5105105105105100");
payload.put("expiration_month", 12);
payload.put("expiration_year", 2020);
payload.put("security_code", "123");

Card card = new Card(payload);
card.save();

% endif

