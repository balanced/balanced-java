% if mode == 'definition':
Order().save()

% else:
Balanced.configure("ak-test-2fYjkv4Tz5l3iPCtOlgLolmF15XPXlRCr");

Order order = new Order("/orders/OR16uowitglVKoM6x5DxkKVq");

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

