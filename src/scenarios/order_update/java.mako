% if mode == 'definition':
Order().save()

% else:
Balanced.configure("ak-test-2eKlj1ZDfAcZSARMf3NMhBHywDej0avSY");

Order order = new Order("/orders/OR6nHTLOYehaSU5SoxqQE5WB");

Map<String, String> meta = new HashMap<String, String>();
meta.put("product.id", "1234567890");
meta.put("anykey", "valuegoeshere");

order.meta = meta;
order.description = "New description for order";

try {
    order.save();
}
catch (HTTPError e) {}

% endif

