% if mode == 'definition':
    Account.associateCard

% else:
    Account account = new Account();
    account.associateCard("/v1/marketplaces/TEST-MP29J5STPtZVvnjAFndM0N62/cards/CC2DQ8AbcEnU9KQ0DDOavq36");

% endif

