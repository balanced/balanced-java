% if mode == 'definition':
Order().debit(Map<String, Object> payload)

% else:
Balanced.configure("ak-test-aUV295IugdhWSNx2JFckYBCSvfY2ibgq");

Card card = new Card("/cards/CC1r57n36Fbiglw0OcSEkUcN");
Order order = new Order("/orders/OR1s2WQKp0shLH9Qb0LiUfEJ");

HashMap<String, Object> payload = new HashMap<String, Object>();
payload.put("amount", 5000);

try {
    Debit debit = order.debitFrom(card, payload);
}
catch (HTTPError e) {}

% endif

