% if mode == 'definition':
Customer.refunds

% else:
Balanced.configure("ak-test-1p1Tsac7gHeMQowL2seB7ieliuAJAufyq");

Customer customer = new Customer("/v1/customers/CUuDKfPHvZhTmaNbEsg1BOO");
Refund.Collection refunds = customer.refunds;

% endif

