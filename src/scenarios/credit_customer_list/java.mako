% if mode == 'definition':
Customer.credits;

% else:
Settings.configure("c07a8282f49111e2a035026ba7d31e6f");

// this scenario is not present in scenarios.cache
// so the customer_uri will be rendered as an empty string
Customer customer = new Customer("");
Credit.Collection credits = customer.credits;

% endif

