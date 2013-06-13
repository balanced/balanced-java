% if mode == 'definition':
    BankAccount.credit(amount);

% else:
    BankAccount ba = new BankAccount("/v1/bank_accounts/BA6aflmsJEE7FldgQGpsgW0u");
    ba.credit(10000);

% endif

