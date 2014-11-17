% if mode == 'definition':
BankAccountVerification.save()

% else:
Balanced.configure("ak-test-25ZY8HQwZPuQtDecrxb671LilUya5t5G0");

BankAccountVerification verification = new BankAccountVerification("/verifications/BZ1eMAsKt13lIj2SkvvHlxfT");
try {
    verification.confirm(1, 1);
}
catch (HTTPError e) {}

% endif

