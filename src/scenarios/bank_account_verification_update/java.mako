% if mode == 'definition':
BankAccountVerification.save();

% else:
Settings.configure("6f755804f3e111e295f6026ba7cd33d0");

BankAccount ba = new BankAccount("/v1/bank_accounts/BA3KPriol4oA5MwrDmSR7it0");
ba.verification_uri = "/v1/bank_accounts/BA3KPriol4oA5MwrDmSR7it0/verifications/BZ3LwQtgS0tOcJbOAwzPDz8k";
BankAccountVerification verification = ba.getVerification();
verification.confirm(1, 1);
verification.save();

% endif

