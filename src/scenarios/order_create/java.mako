% if mode == 'definition':
Customer().createOrder(Map<String, Object> payload)

% else:
Balanced.configure("ak-test-1ByQgRpcQLTwmOhCBUofyIHm0r96qPm8s");

Customer customer = new Customer("/customers/CU1eX3FIMntmCLmi2VfWA2db");

Map<String, Object> payload = new HashMap<String, Object>();
payload.put("description", "Order #12341234");

try {
    customer.createOrder(payload);
}
catch (HTTPError e) {}

% endif

