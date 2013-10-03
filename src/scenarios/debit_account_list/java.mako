% if mode == 'definition':
Account.debits;

% else:
Balanced.configure("ak-test-2ppXve1BnInnsIKZytspDrsuhjtAT9dD8");

Account account = new Account("");
Debit.Collection debits = account.debits;

% endif

