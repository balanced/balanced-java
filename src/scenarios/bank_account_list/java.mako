% if mode == 'definition':
BankAccount.Collection(String uri);

% else:
Settings.configure("c07a8282f49111e2a035026ba7d31e6f");

BankAccount.Collection bankAccounts = new BankAccount.Collection("/v1/bank_accounts");

% endif

