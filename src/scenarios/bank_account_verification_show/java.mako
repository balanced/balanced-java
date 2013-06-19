% if mode == 'definition':
BankAccount.getVerification()

% else:
BankAccount ba = new BankAccount("/v1/bank_accounts/BA6h13dSUEsvVjbhFd2MqdmT");
ba.verification_uri = "/v1/bank_accounts/BA6h13dSUEsvVjbhFd2MqdmT/verifications/BZ6hHnC9dKqiQJJtuxbp7SGP";
BankAccountVerification verification = ba.getVerification();

% endif

