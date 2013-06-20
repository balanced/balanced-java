% if mode == 'definition':
Card card = new Card(Map<String, Object> payload);

% else:
Settings.configure("2776ea40d92e11e29fe1026ba7cac9da");

Map<String, Object> payload = new HashMap<String, Object>();
payload.put("card_number", "5105105105105100");
payload.put("expiration_month", 12);
payload.put("expiration_year", 2020);
payload.put("security_code", "123");
Card card = new Card(payload);
card.save();

% endif

