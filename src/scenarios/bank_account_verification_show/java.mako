% if mode == 'definition':
BankAccount.getVerification()

% else:
BankAccount ba = new BankAccount("/v1/bank_accounts/BA1oRQpLj6VsbSYZydExip2W");
ba.verification_uri = "/v1/bank_accounts/BA1oRQpLj6VsbSYZydExip2W/verifications/BZ1pLd7LVozj3BXOjejENvbi";
BankAccountVerification verification = ba.getVerification();

% endif

