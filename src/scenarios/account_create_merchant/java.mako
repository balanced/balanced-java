% if mode == 'definition':
Account.associateBankAccount(String uri);

% else:
Account account = new Account();
account.associateBankAccount("/v1/bank_accounts/BA1KawqyAPjlJABtlpNxhatp");

% endif

