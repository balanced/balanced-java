% if mode == 'definition':
Customer.credits;

% else:
// this scenario is not present in scenarios.cache
// so the customer_uri will be rendered as an empty string
Customer customer = new Customer("");
Credit.Collection credits = customer.credits;

% endif

