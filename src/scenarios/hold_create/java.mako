% if mode == 'definition':
Card card = new Card();

% else:
    Account account = new Account("/v1/marketplaces/TEST-MP29J5STPtZVvnjAFndM0N62/accounts/AC2CcqNuwOGPFi8oaeeVik6y");
    account.hold( 5000,
                  Some descriptive text for the debit in the dashboard,
                  /v1/marketplaces/TEST-MP29J5STPtZVvnjAFndM0N62/accounts/AC2CcqNuwOGPFi8oaeeVik6y);
    account.save();

% endif

