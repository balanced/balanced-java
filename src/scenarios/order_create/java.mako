% if mode == 'definition':
Customer().createOrder(Map<String, Object> payload)

% else:
Balanced.configure("ak-test-2eKlj1ZDfAcZSARMf3NMhBHywDej0avSY");

Customer customer = new Customer("/customers/CU5AxbQrjAcjsbquafnvwaas");

Map<String, Object> payload = new HashMap<String, Object>();
payload.put("description", "Order #12341234");

try {
    customer.createOrder(payload);
}
catch (HTTPError e) {}

% endif

