% if mode == 'definition':
Card(Map<String, Object> payload)

% else:
Balanced.configure("ak-test-2cSDy37BKy5K4NUHKHVNXNTjTHPEqjRtB");

Map<String, Object> payload = new HashMap<String, Object>();
payload.put("number", "5105105105105100");
payload.put("expiration_month", 12);
payload.put("expiration_year", 2020);
payload.put("cvv", "123");

Card card = new Card(payload);
card.save();

% endif

