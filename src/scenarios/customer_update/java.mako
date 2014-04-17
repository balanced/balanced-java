% if mode == 'definition':
Customer().save()

% else:
Balanced.configure("ak-test-2fYjkv4Tz5l3iPCtOlgLolmF15XPXlRCr");

Customer customer = new Customer("/customers/CUUybBMdV1fZ7BXjdL58BVt");

Map<String, String> meta = new HashMap<String, String>();
meta.put("shipping-preference", "ground");

customer.meta = meta;
customer.email = "email@newdomain.com";

try {
    customer.save();
}
catch (HTTPError e) {}

% endif

