% if mode == 'definition':
Customer.holds;

% else:
Customer customer = new Customer("");
Hold.Collection holds = customer.holds;

% endif

