% if mode == 'definition':
BankAccount.Collection(String uri)

% else:
Balanced.configure("ak-test-2ppXve1BnInnsIKZytspDrsuhjtAT9dD8");

BankAccount.Collection bankAccounts = new BankAccount.Collection("/v1/bank_accounts");

% endif

