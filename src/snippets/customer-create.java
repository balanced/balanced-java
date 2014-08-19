Map<String, Object> address = new HashMap<String, Object>();
address.put("postal_code", "48120");

Map<String, Object> payload = new HashMap<String, Object>();
payload.put("name", "Henry Ford");
payload.put("dob_month", 7);
payload.put("dob_year", 1963);
payload.put("address", address);

Customer merchant = new Customer(payload);

try {
    merchant.save();
}
catch (HTTPError e) {}