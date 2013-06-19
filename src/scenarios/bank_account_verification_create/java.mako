% if mode == 'definition':
BankAccount.verify()

% else:
BankAccount ba = new BankAccount("/v1/bank_accounts/BA6eYWlzH1IMkOpPYQjRNme4/verifications");
ba.verify();

% endif

