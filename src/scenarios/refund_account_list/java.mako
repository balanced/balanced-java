% if mode == 'definition':
Account.refunds

% else:
Balanced.configure("ak-test-1p1Tsac7gHeMQowL2seB7ieliuAJAufyq");

Account account = new Account("");
Refund.Collection refunds = account.refunds;

% endif

