% if mode == 'definition':
    BankAccount.verify()

% else:
    BankAccount ba = new BankAccount("/v1/bank_accounts/BA2k3nC4a9llhZFWsBjdGuKI/verifications");
    ba.verify();

% endif

