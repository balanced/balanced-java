% if mode == 'definition':
BankAccountVerification.save()

% else:
Balanced.configure("ak-test-1ByQgRpcQLTwmOhCBUofyIHm0r96qPm8s");

BankAccountVerification verification = new BankAccountVerification("/verifications/BZ2AZ05mk2SQsEcicjSh3UN");
try {
    verification.confirm(1, 1);
}
catch (HTTPError e) {}

% endif

