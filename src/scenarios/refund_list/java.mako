% if mode == 'definition':
Refund.Collection = new Refund.Collection(String uri);

% else:
Settings.configure("6f755804f3e111e295f6026ba7cd33d0");

Refund.Collection refunds = new Refund.Collection("/v1/marketplaces/TEST-MP3oDYBxCRm2CVSWGt1RRctG/refunds");

% endif

