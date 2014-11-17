% if mode == 'definition':
Order().creditTo(Card card, Map<String, Object> payload)

% else:
Balanced.configure("ak-test-25ZY8HQwZPuQtDecrxb671LilUya5t5G0");

Card card = new Card("/cards/CC3IBNr3erYpVuuZDyWNFfet");
Order order = new Order("/orders/OR2UWXCNY2nKlqIQhQhWN3Jm");

HashMap<String, Object> payload = new HashMap<String, Object>();
payload.put("amount", 5000);

try {
    Credit credit = order.creditTo(card, payload);
}
catch (HTTPError e) {}

% endif

