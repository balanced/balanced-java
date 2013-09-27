% if mode == 'definition':
BankAccountVerification.save();

% else:
Balanced.configure("71d76c1223ad11e38848026ba7c1aba6");

BankAccountVerification verification = new BankAccountVerification("/v1/bank_accounts/BA3YXRiVoKoMJMhq3Bfwxyu2/verifications/BZ40XvdMDOfXN0T7fIlFF4U8");
verification.confirm(1, 1);
verification.save();

% endif

