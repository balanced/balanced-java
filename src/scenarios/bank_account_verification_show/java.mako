% if mode == 'definition':
BankAccount.getVerification();

% else:
Settings.configure("2776ea40d92e11e29fe1026ba7cac9da");

BankAccount ba = new BankAccount("/v1/bank_accounts/BA1oRQpLj6VsbSYZydExip2W");
ba.verification_uri = "/v1/bank_accounts/BA1oRQpLj6VsbSYZydExip2W/verifications/BZ1pLd7LVozj3BXOjejENvbi";
BankAccountVerification verification = ba.getVerification();

% endif

