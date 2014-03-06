% if mode == 'definition':
Customer().createOrder(Map<String, Object> payload)

% else:
Balanced.configure("ak-test-2cSDy37BKy5K4NUHKHVNXNTjTHPEqjRtB");

Customer customer = new Customer("/customers/CU4EeI9UPzRcOo2C3j1qFjQj");

Map<String, Object> payload = new HashMap<String, Object>();
payload.put("description", "Order #12341234");

try {
    customer.createOrder(payload);
}
catch (HTTPError e) {}

% endif

