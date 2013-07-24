% if mode == 'definition':
Customer.credits;

% else:
Settings.configure("6f755804f3e111e295f6026ba7cd33d0");

// this scenario is not present in scenarios.cache
// so the customer_uri will be rendered as an empty string
Customer customer = new Customer("");
Credit.Collection credits = customer.credits;

% endif

