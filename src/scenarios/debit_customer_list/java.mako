% if mode == 'definition':
Customer.debits

% else:
Balanced.configure("ak-test-1p1Tsac7gHeMQowL2seB7ieliuAJAufyq");

Customer customer = new Customer("/v1/customers/CU7wGDVh8FjYMPfkPl9SzWAu");
Debit.Collection debits = customer.debits;

% endif

