Map<String, Object> creditPayload = new HashMap<String, Object>();
creditPayload.put("description", "A simple description");
creditPayload.put("amount", 5000);
creditPayload.put("order", order.href);

Credit credit = payableAccount.credit(creditPayload);