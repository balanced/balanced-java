% if mode == 'definition':
Card card = new Card(Map<String, Object> payload);

% else:
Balanced.configure("71d76c1223ad11e38848026ba7c1aba6");

Map<String, Object> payload = new HashMap<String, Object>();
payload.put("card_number", "5105105105105100");
payload.put("expiration_month", 12);
payload.put("expiration_year", 2020);
payload.put("security_code", "123");

Card card = new Card(payload);
card.save();

% endif

