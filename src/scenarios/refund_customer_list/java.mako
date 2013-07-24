% if mode == 'definition':
Customer.refunds;

% else:
Settings.configure("c07a8282f49111e2a035026ba7d31e6f");

Customer customer = new Customer("");
Refund.Collection refunds = customer.refunds;

% endif

