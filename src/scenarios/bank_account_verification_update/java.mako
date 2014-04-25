% if mode == 'definition':
BankAccountVerification.save()

% else:
Balanced.configure("ak-test-22IOkhevjZlmRP2do6CZixkkDshTiOjTV");

BankAccountVerification verification = new BankAccountVerification("/verifications/BZ3KkIZuSazKfqFrFIfsrhmB");
try {
    verification.confirm(1, 1);
}
catch (HTTPError e) {}

% endif

