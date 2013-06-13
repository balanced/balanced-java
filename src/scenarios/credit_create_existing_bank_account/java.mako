% if mode == 'definition':
    BankAccount.credit(amount);

% else:
    BankAccount ba = new BankAccount("/v1/bank_accounts/BA2fU4b0MNuBHuI3NrvyOsTE");
    ba.credit(10000);

% endif

