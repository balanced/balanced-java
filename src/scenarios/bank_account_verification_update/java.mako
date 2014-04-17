% if mode == 'definition':
BankAccountVerification.save()

% else:
Balanced.configure("ak-test-2fYjkv4Tz5l3iPCtOlgLolmF15XPXlRCr");

BankAccountVerification verification = new BankAccountVerification("/verifications/BZ7zjJJJqb1VU633qQw0z1Vc");
try {
    verification.confirm(1, 1);
}
catch (HTTPError e) {}

% endif

