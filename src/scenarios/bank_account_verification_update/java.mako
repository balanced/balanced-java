% if mode == 'definition':
BankAccountVerification.confirm(...)

% else:
BankAccount ba = new BankAccount("/v1/bank_accounts/BA6joBOllXBzGbYKpa4PCiGQ");
ba.verification_uri = "/v1/bank_accounts/BA6joBOllXBzGbYKpa4PCiGQ/verifications/BZ6kgUuE7JInbXvZLxJqMqnR";
BankAccountVerification verification = ba.getVerification();
verification.confirm(1, 1);

% endif

