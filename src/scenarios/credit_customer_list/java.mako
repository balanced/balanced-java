% if mode == 'definition':
Customer.credits;

% else:
Settings.configure("2776ea40d92e11e29fe1026ba7cac9da");

// this scenario is not present in scenarios.cache
// so the customer_uri will be rendered as an empty string
Customer customer = new Customer("");
Credit.Collection credits = customer.credits;

% endif

