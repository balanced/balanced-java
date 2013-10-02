% if mode == 'definition':
Customer.holds;

% else:
Settings.configure("c07a8282f49111e2a035026ba7d31e6f");

Customer customer = new Customer("");
Hold.Collection holds = customer.holds;

% endif

