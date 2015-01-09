% if mode == 'definition':
Customer().save()

% else:
Balanced.configure("ak-test-2eKlj1ZDfAcZSARMf3NMhBHywDej0avSY");

Customer customer = new Customer("/customers/CU5aACCvYYfV6mcWJL4TEcK1");

Map<String, String> meta = new HashMap<String, String>();
meta.put("shipping-preference", "ground");

customer.meta = meta;
customer.email = "email@newdomain.com";

try {
    customer.save();
}
catch (HTTPError e) {}

% endif

