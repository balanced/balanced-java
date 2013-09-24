% if mode == 'definition':
Customer.refunds;

% else:
Settings.configure("71d76c1223ad11e38848026ba7c1aba6");

Customer customer = new Customer("/v1/customers/CU5uG18syxNwvFGdbknjZmoo");
Refund.Collection refunds = customer.refunds;

% endif

