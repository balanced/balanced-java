% if mode == 'definition':
BankAccountVerification.confirm(...)

% else:
BankAccount ba = new BankAccount("/v1/bank_accounts/BA41dRutrHZw7BmNEXj3TOGe");
ba.verification_uri = "/v1/bank_accounts/BA41dRutrHZw7BmNEXj3TOGe/verifications/BZ41SacHw9PRMxC0zA3Vk0DA";
BankAccountVerification verification = ba.getVerification();
verification.confirm(1, 1);

% endif

