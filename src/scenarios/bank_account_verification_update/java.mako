% if mode == 'definition':
BankAccountVerification.save()

% else:
Balanced.configure("ak-test-2ppXve1BnInnsIKZytspDrsuhjtAT9dD8");

BankAccountVerification verification = new BankAccountVerification("/v1/bank_accounts/BA3Cc1WHeLCM0GhP6havpp7N/verifications/BZ3ErxujTs0WxUs2EiMMtre7");
verification.confirm(1, 1);
verification.save();

% endif

