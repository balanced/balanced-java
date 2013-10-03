% if mode == 'definition':
Account.credit(int amount);

% else:
Balanced.configure("ak-test-2ppXve1BnInnsIKZytspDrsuhjtAT9dD8");

Account account = new Account("");
account.credit(100);

% endif

