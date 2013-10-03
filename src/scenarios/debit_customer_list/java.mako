% if mode == 'definition':
Customer.debits

% else:
Balanced.configure("ak-test-2ppXve1BnInnsIKZytspDrsuhjtAT9dD8");

Customer customer = new Customer("/v1/customers/CU4sDLDP25PDb3P3BgFM6s4e");
Debit.Collection debits = customer.debits;

% endif

