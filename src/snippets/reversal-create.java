// creditHref is the stored href for the Credit
// orderHref is the stored href for the Order
Credit credit = new Credit(creditHref);

HashMap<String, Object> meta = new HashMap<String, Object>();
meta.put("user.refund_reason", "not happy with product");
meta.put("merchant.feedback", "positive");
meta.put("fulfillment.item.condition", "OK");

HashMap<String, Object> payload = new HashMap<String, Object>();
payload.put("amount", 100000);
payload.put("description", "Reversal for Order #1111");
payload.put("meta", meta);
payload.put("order", orderHref);

try {
    credit.reverse(payload);
}
catch (HTTPError e) {}