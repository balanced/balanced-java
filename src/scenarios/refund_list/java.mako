% if mode == 'definition':
Refund.Collection = new Refund.Collection(String uri);

% else:
Settings.configure("c07a8282f49111e2a035026ba7d31e6f");

Refund.Collection refunds = new Refund.Collection("/v1/marketplaces/TEST-MP5Rwi1N0GqQZ9nAyf11c2v0/refunds");

% endif

