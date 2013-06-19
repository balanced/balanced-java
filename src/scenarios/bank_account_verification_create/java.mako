% if mode == 'definition':
BankAccount.verify()

% else:
BankAccount ba = new BankAccount("/v1/bank_accounts/BA1mOWnGISRn9236e6tOuDLq/verifications");
ba.verify();

% endif

