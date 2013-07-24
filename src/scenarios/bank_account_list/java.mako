% if mode == 'definition':
BankAccount.Collection(String uri);

% else:
Settings.configure("6f755804f3e111e295f6026ba7cd33d0");

BankAccount.Collection bankAccounts = new BankAccount.Collection("/v1/bank_accounts");

% endif

