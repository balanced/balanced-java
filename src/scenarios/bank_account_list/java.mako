% if mode == 'definition':
BankAccount.Collection(String uri)

% else:
Balanced.configure("ak-test-1p1Tsac7gHeMQowL2seB7ieliuAJAufyq");

BankAccount.Collection bankAccounts = new BankAccount.Collection("/v1/bank_accounts");

% endif

