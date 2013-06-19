% if mode == 'definition':
Customer.refunds

% else:
Customer customer = new Customer("");
Refund.Collection refunds = customer.refunds;

% endif

