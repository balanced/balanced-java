% if mode == 'definition':
BankAccountVerification.save()

% else:
Balanced.configure("ak-test-2cSDy37BKy5K4NUHKHVNXNTjTHPEqjRtB");

BankAccountVerification verification = new BankAccountVerification("/verifications/BZ3NheXIi1UxUiNtkaSo1ZI5");
verification.confirm(1, 1);

% endif

