% if mode == 'definition':
BankAccount.credit(amount);

% else:
BankAccount ba = new BankAccount("/v1/bank_accounts/BA3S82mRZS12C8AkQ8flcYXB");
ba.credit(10000);

% endif

