% if mode == 'definition':
Order().debitFrom(Card card, Map<String, Object> payload)

% else:
Balanced.configure("ak-test-aUV295IugdhWSNx2JFckYBCSvfY2ibgq");

Card card = new Card("/cards/CC5OD6648yiKfSzfj6z6MdXr");
Order order = new Order("/orders/OR5QcYnwysJXQswImokq6ZSx");

HashMap<String, Object> payload = new HashMap<String, Object>();
payload.put("amount", 5000);

try {
    Debit debit = order.debitFrom(card, payload);
}
catch (HTTPError e) {}

% endif

