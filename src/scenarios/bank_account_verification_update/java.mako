% if mode == 'definition':
BankAccountVerification.save()

% else:
Balanced.configure("ak-test-1p1Tsac7gHeMQowL2seB7ieliuAJAufyq");

BankAccountVerification verification = new BankAccountVerification("/v1/bank_accounts/BA6nZLdijPKzQ8RhJNnN1OD6/verifications/BZ6s3ghAmwY5BhnJIrCKSkUo");
verification.confirm(1, 1);
verification.save();

% endif

