% if mode == 'definition':
    Refund.Collection = new Refund.Collection(uri);

% else:
    Refund.Collection refunds = new Refund.Collection("/v1/marketplaces/TEST-MP64bmAzypIUS0SUZ4qkoFqG/refunds");

% endif

