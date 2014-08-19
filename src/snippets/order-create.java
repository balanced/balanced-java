Map<String, Object> descriptionPayload = new HashMap<String, Object>();
descriptionPayload.put("description", "Order #12341234");

try {
    merchant.createOrder(descriptionPayload);
}
catch (HTTPError e) {}
