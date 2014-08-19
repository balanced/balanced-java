Debit debit = order.debits.query().first();

HashMap<String, Object> refundMeta = new HashMap<String, Object>();
refundMeta.put("user.refund_reason", "not happy with product");
refundMeta.put("merchant.feedback", "positive");
refundMeta.put("fulfillment.item.condition", "OK");

HashMap<String, Object> refundPayload = new HashMap<String, Object>();
refundPayload.put("amount", 10000);
refundPayload.put("description", "Refund for Order #1111");
refundPayload.put("meta", refundMeta);

try {
    debit.refund(refundPayload);
}
catch (HTTPError e) {}