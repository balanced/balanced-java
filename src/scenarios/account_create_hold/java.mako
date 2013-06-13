% if mode == 'definition':
    Account.hold(...)

% else:
    Account account = new Account("/v1/marketplaces/TEST-MP29J5STPtZVvnjAFndM0N62/accounts/AC41WWE1V0nZtw5J8BicNwnB");
    Hold hold = account.hold(1000);

% endif

