% if mode == 'definition':
Customer.refunds

% else:
Balanced.configure("ak-test-2ppXve1BnInnsIKZytspDrsuhjtAT9dD8");

Customer customer = new Customer("/v1/customers/CU5eN73VZL9xr3qR4VIgtTZI");
Refund.Collection refunds = customer.refunds;

% endif

