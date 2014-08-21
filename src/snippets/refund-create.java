// debitHref is the stored href for the Debit
// orderHref is the stored href for the Order
Debit debit = new Debit(debitHref);

HashMap<String, Object> meta = new HashMap<String, Object>();
meta.put("user.refund_reason", "not happy with product");
meta.put("merchant.feedback", "positive");
meta.put("fulfillment.item.condition", "OK");

HashMap<String, Object> payload = new HashMap<String, Object>();
payload.put("amount", 3000);
payload.put("description", "Refund for Order #1111");
payload.put("meta", meta);
payload.put("order", orderHref);

try {
    debit.refund(payload);
}
catch (HTTPError e) {}