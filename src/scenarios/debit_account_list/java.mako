% if mode == 'definition':
Account.debits

% else:
Balanced.configure("ak-test-1p1Tsac7gHeMQowL2seB7ieliuAJAufyq");

Account account = new Account("");
Debit.Collection debits = account.debits;

% endif

