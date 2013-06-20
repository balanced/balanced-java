% if mode == 'definition':
BankAccountVerification.save();

% else:
Settings.configure("2776ea40d92e11e29fe1026ba7cac9da");

BankAccount ba = new BankAccount("/v1/bank_accounts/BA1r9dSqsfWLIAN3APL4yEh2");
ba.verification_uri = "/v1/bank_accounts/BA1r9dSqsfWLIAN3APL4yEh2/verifications/BZ1rOZcf3vZlsH6ne5tRqiL6";
BankAccountVerification verification = ba.getVerification();
verification.confirm(1, 1);
verification.save();

% endif

