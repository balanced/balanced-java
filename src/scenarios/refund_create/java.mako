% if mode == 'definition':
Debit().refund()

% else:
Balanced.configure("ak-test-2wIOi20ITgc1u1Lw6UM3y5ZZjZ66M8HMf");

Debit debit = new Debit("/debits/WD6GYJu1hYxqJrpXspjFtKSI");

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

