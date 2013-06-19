% if mode == 'definition':
Customer.refunds

% else:
Customer customer = new Customer("/v1/customers/CU6W5pSk2CUXQxhENqyGRvQe");
Refund.Collection refunds = customer.refunds;

% endif

