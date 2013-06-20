% if mode == 'definition':
BankAccount.Collection(String uri);

% else:
BankAccount.Collection bankAccounts = new BankAccount.Collection("/v1/bank_accounts");

% endif

