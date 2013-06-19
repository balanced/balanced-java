% if mode == 'definition':
BankAccount.getVerification()

% else:
BankAccount ba = new BankAccount("/v1/bank_accounts/BA3Z85niaHoMYc3a9u5tRftg");
ba.verification_uri = "/v1/bank_accounts/BA3Z85niaHoMYc3a9u5tRftg/verifications/BZ3ZGV33SRDiCfzUcrLxnfFd";
BankAccountVerification verification = ba.getVerification();

% endif

