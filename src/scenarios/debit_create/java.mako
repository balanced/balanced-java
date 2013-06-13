% if mode == 'definition':
    Account.debit(int amount,
                  String description,
                  String source_uri,
                  String appears_on_statement_as,
                  Map<String, String> meta)

% else:
    Account account = new Account("/v1/marketplaces/TEST-MP29J5STPtZVvnjAFndM0N62/accounts/AC2CcqNuwOGPFi8oaeeVik6y");
    account.debit( 5000,
                   Some descriptive text for the debit in the dashboard,
                   /v1/marketplaces/TEST-MP29J5STPtZVvnjAFndM0N62/accounts/AC2CcqNuwOGPFi8oaeeVik6y,
                   Statement text,
                   null);

% endif

