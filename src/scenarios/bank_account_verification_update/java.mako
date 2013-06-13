% if mode == 'definition':
    BankAccountVerification.confirm(...)

% else:
        BankAccount ba = new BankAccount("/v1/bank_accounts/BA2q0W6DqBAtytLyfBAD4p3y");
        ba.verification_uri = "/v1/bank_accounts/BA2q0W6DqBAtytLyfBAD4p3y/verifications/BZ2qWyR9zEOhUA4a1nVPXO4T";
        BankAccountVerification verification = ba.getVerification();
        verification.confirm(1, 1);

% endif

