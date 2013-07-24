% if mode == 'definition':
Card card = new Card(Map<String, Object> payload);

% else:
Settings.configure("c07a8282f49111e2a035026ba7d31e6f");

Map<String, Object> payload = new HashMap<String, Object>();
payload.put("card_number", "5105105105105100");
payload.put("expiration_month", 12);
payload.put("expiration_year", 2020);
payload.put("security_code", "123");
Card card = new Card(payload);
card.save();

% endif

