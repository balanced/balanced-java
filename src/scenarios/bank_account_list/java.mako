% if mode == 'definition':
BankAccount.Collection

% else:
BankAccount.Collection bankAccounts = new BankAccount.Collection("/v1/bank_accounts");

% endif

