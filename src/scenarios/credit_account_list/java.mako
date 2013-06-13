% if mode == 'definition':
    Credit.Collection credits = new Credit.Collection(uri);

% else:
    Credit.Collection credits = new Credit.Collection("/v1/marketplaces/TEST-MP29J5STPtZVvnjAFndM0N62/accounts/AC2CcqNuwOGPFi8oaeeVik6y/credits");

% endif

