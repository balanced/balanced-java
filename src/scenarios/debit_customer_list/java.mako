% if mode == 'definition':
    Customer.debits

% else:
    Customer customer = new Customer("");
    Debit.Collection debits  = customer.debits;

% endif

