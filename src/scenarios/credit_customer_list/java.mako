% if mode == 'definition':
Customer.credits

% else:
Customer customer = new Customer("");
Credit.Collection credits = customer.credits;

% endif

