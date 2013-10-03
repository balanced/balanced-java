% if mode == 'definition':
Account.refunds;

% else:
Balanced.configure("ak-test-2ppXve1BnInnsIKZytspDrsuhjtAT9dD8");

Account account = new Account("");
Refund.Collection refunds = account.refunds;

% endif

