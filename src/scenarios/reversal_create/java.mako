% if mode == 'definition':
Credit().reverse()

% else:
Balanced.configure("ak-test-1xLFE6RLC1W3P4ePiQDI4UVpRwtKcdfqL");

Credit credit = new Credit("/credits/CR5wJCGIh24U6yzbDGmWlMhL");

HashMap<String, Object> meta = new HashMap<String, Object>();
meta.put("user.refund_reason", "not happy with product");
meta.put("merchant.feedback", "positive");
meta.put("fulfillment.item.condition", "OK");

HashMap<String, Object> payload = new HashMap<String, Object>();
payload.put("amount", 3000);
payload.put("description", "Reversal for Order #1111");
payload.put("meta", meta);

try {
    credit.reverse(payload);
}
catch (HTTPError e) {}

% endif

