% if mode == 'definition':
Refund.Collection = new Refund.Collection(uri);

% else:
Refund.Collection refunds = new Refund.Collection("/v1/marketplaces/TEST-MP3MuCwscFiUbhv2Z2lB49cQ/refunds");

% endif

