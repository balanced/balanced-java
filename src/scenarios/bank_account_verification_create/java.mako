% if mode == 'definition':
BankAccount.verify()

% else:
BankAccount ba = new BankAccount("/v1/bank_accounts/BA3X9madzYu5zQybfb43pOer/verifications");
ba.verify();

% endif

