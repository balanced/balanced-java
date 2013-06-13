% if mode == 'definition':
    Refund.Collection = new Refund.Collection(uri);

% else:
    Refund.Collection = new Refund.Collection("/v1/marketplaces/TEST-MP29J5STPtZVvnjAFndM0N62/refunds");

% endif

