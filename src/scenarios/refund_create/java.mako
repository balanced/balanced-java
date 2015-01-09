% if mode == 'definition':
Debit().refund()

% else:
Balanced.configure("ak-test-1xLFE6RLC1W3P4ePiQDI4UVpRwtKcdfqL");

Debit debit = new Debit("/debits/WD4wXVn2sS8lXuKATwXOf7Uc");

HashMap<String, Object> meta = new HashMap<String, Object>();
meta.put("user.refund_reason", "not happy with product");
meta.put("merchant.feedback", "positive");
meta.put("fulfillment.item.condition", "OK");

HashMap<String, Object> payload = new HashMap<String, Object>();
payload.put("amount", 3000);
payload.put("description", "Refund for Order #1111");
payload.put("meta", meta);

try {
    debit.refund(payload);
}
catch (HTTPError e) {}

% endif

