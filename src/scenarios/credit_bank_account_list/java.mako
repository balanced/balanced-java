% if mode == 'definition':
BankAccount.credits

% else:
Balanced.configure("ak-test-2ppXve1BnInnsIKZytspDrsuhjtAT9dD8");

BankAccount bankAccount = new BankAccount("/v1/bank_accounts/BA3GU9eoZ5YrnVZWPtmfZrNt");
Credit.Collection credits = bankAccount.credits;

% endif

