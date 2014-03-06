% if mode == 'definition':
Customer().save()

% else:
Balanced.configure("ak-test-2cSDy37BKy5K4NUHKHVNXNTjTHPEqjRtB");

Customer customer = new Customer("/customers/CU4xpIqZ7mf2fuLpBoXgoG7m");

Map<String, String> meta = new HashMap<String, String>();
meta.put("shipping-preference", "ground");

customer.meta = meta;
customer.email = "email@newdomain.com";

try {
    customer.save();
}
catch (HTTPError e) {}

% endif

