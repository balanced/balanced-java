% if mode == 'definition':
Order().save()

% else:
Balanced.configure("ak-test-1xLFE6RLC1W3P4ePiQDI4UVpRwtKcdfqL");

Order order = new Order("/orders/OR57cG7I7627Xl7Mh3OrVNn7");

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

