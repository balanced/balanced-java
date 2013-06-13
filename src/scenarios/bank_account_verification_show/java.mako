% if mode == 'definition':
    BankAccount.getVerification()

% else:
    BankAccount ba = new BankAccount("/v1/bank_accounts/BA2mettVyrsL0krXEXeS1kes");
    ba.verification_uri = "/v1/bank_accounts/BA2mettVyrsL0krXEXeS1kes/verifications/BZ2nq1jnVFkXGR1pxbF1qrm8";
    BankAccountVerification verification = ba.getVerification();

% endif

