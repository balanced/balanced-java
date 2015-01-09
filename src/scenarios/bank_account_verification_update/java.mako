% if mode == 'definition':
BankAccountVerification.save()

% else:
Balanced.configure("ak-test-1xLFE6RLC1W3P4ePiQDI4UVpRwtKcdfqL");

BankAccountVerification verification = new BankAccountVerification("/verifications/BZ5XxtvPAMXrKcmyaN1DFqfK");
try {
    verification.confirm(1, 1);
}
catch (HTTPError e) {}

% endif

