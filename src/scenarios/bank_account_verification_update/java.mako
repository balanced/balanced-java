% if mode == 'definition':
BankAccountVerification.save();

% else:
Settings.configure("c07a8282f49111e2a035026ba7d31e6f");

BankAccount ba = new BankAccount("/v1/bank_accounts/BA6eH8LiVZfh1Nj1bxiUs4D4");
ba.verification_uri = "/v1/bank_accounts/BA6eH8LiVZfh1Nj1bxiUs4D4/verifications/BZ6fwAVxcoLksTxGQChYakKH";
BankAccountVerification verification = ba.getVerification();
verification.confirm(1, 1);
verification.save();

% endif

