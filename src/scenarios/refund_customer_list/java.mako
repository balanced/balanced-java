% if mode == 'definition':
Customer.refunds;

% else:
Settings.configure("6f755804f3e111e295f6026ba7cd33d0");

Customer customer = new Customer("");
Refund.Collection refunds = customer.refunds;

% endif

