% if mode == 'definition':
BankAccount.credit(int amount);

% else:
BankAccount ba = new BankAccount("/v1/bank_accounts/BA1iViFZ5fKWIixl3fpq07Je");
ba.credit(10000);

% endif

