Map<String, String> meta = new HashMap<String, String>();
meta.put("product.id", "1234567890");

order.meta = meta;
order.description = "New description for order";

try {
    order.save();
}
catch (HTTPError e) {}