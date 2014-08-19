Credit credit = order.credits.query().first();

HashMap<String, Object> reversalMeta = new HashMap<String, Object>();
reversalMeta.put("user.refund_reason", "not happy with product");
reversalMeta.put("merchant.feedback", "positive");
reversalMeta.put("fulfillment.item.condition", "OK");

HashMap<String, Object> reversalPayload = new HashMap<String, Object>();
reversalPayload.put("amount", 8000);
reversalPayload.put("description", "Reversal for Order #1111");
reversalPayload.put("meta", reversalMeta);

try {
    credit.reverse(reversalPayload);
}
catch (HTTPError e) {}