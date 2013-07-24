% if mode == 'definition':
Card.debit(int amount)

% else:
Settings.configure("6f755804f3e111e295f6026ba7cd33d0");

Map<String, Object> payload = new HashMap<String, Object>();
payload.put("card_number", "5105105105105100");
payload.put("expiration_month", 12);
payload.put("expiration_year", 2020);
payload.put("security_code", "123");
Card card = new Card(payload);
card.save();

Customer customer = new Customer();
customer.addCard(card);
card.refresh();
card.debit(1000);

% endif

