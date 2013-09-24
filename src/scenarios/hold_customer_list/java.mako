% if mode == 'definition':
Customer.holds;

% else:
Settings.configure("71d76c1223ad11e38848026ba7c1aba6");

Customer customer = new Customer("/v1/customers/CU5eFG4rR0x1wP4czF8MxO2I");
Hold.Collection holds = customer.holds;

% endif

