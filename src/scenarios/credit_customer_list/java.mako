% if mode == 'definition':
Customer.credits;

% else:
Settings.configure("71d76c1223ad11e38848026ba7c1aba6");

// this scenario is not present in scenarios.cache
// so the customer_uri will be rendered as an empty string
Customer customer = new Customer("/v1/customers/CU3QbHVO44v9opCiSdarCV14");
Credit.Collection credits = customer.credits;

% endif

