% if mode == 'definition':
    Account.associateCard(card_uri);

% else:
    Account account = new Account("/v1/marketplaces/TEST-MP29J5STPtZVvnjAFndM0N62/accounts");
    account.associateCard("/v1/marketplaces/TEST-MP29J5STPtZVvnjAFndM0N62/cards/CC41v6UdqWO29C3OwHehmkps");

% endif

