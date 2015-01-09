% if mode == 'definition':
BankAccountVerification.save()

% else:
Balanced.configure("ak-test-2eKlj1ZDfAcZSARMf3NMhBHywDej0avSY");

BankAccountVerification verification = new BankAccountVerification("/verifications/BZ3SVvXTx85CrYo8045tr2cU");
try {
    verification.confirm(1, 1);
}
catch (HTTPError e) {}

% endif

