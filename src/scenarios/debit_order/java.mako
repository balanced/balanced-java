% if mode == 'definition':
Order().debitFrom(Card card, Map<String, Object> payload)

% else:
Balanced.configure("ak-test-1xLFE6RLC1W3P4ePiQDI4UVpRwtKcdfqL");

Card card = new Card("/cards/CC2SHYWrrAN9Vvl3vuznGeHu");
Order order = new Order("/orders/OR5e6wrps4tp9QarDxWa01O5");

HashMap<String, Object> payload = new HashMap<String, Object>();
payload.put("amount", 5000);

try {
    Debit debit = order.debitFrom(card, payload);
}
catch (HTTPError e) {}

% endif

