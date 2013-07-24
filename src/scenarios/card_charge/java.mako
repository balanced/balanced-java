% if mode == 'definition':
Card.debit(int amount)

% else:
Settings.configure("2776ea40d92e11e29fe1026ba7cac9da");

Map<String, Object> payload = new HashMap<String, Object>();
payload.put("card_number", "");
payload.put("expiration_month", );
payload.put("expiration_year", );
payload.put("security_code", "");
Card card = new Card(payload);
card.save();

Customer customer = new Customer();
customer.addCard(card);
card.refresh();
card.debit(1000);

% endif

