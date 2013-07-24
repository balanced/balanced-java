% if mode == 'definition':
BankAccount.getVerification();

% else:
Settings.configure("c07a8282f49111e2a035026ba7d31e6f");

BankAccount ba = new BankAccount("/v1/bank_accounts/BA6cFM6KzXjPHL10XfgUKlVQ");
ba.verification_uri = "/v1/bank_accounts/BA6cFM6KzXjPHL10XfgUKlVQ/verifications/BZ6dkH2PP3LQgaXz1qoBVmzl";
BankAccountVerification verification = ba.getVerification();

% endif

