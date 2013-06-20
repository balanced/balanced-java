% if mode == 'definition':
Customer.hold(int amount);

% else:
Customer customer = new Customer("");
customer.hold();

% endif

