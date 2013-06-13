% if mode == 'definition':
    Hold.capture

% else:
    Hold hold = Hold("/v1/marketplaces/TEST-MP29J5STPtZVvnjAFndM0N62/holds/HL4b3zuvRlumVNFMeKl0h5Pk");
    hold.account_uri = "/v1/marketplaces/TEST-MP29J5STPtZVvnjAFndM0N62/accounts/AC41WWE1V0nZtw5J8BicNwnB";
    Account account = hold.getAccount();
    Debit debit = hold.capture(1000);

% endif

