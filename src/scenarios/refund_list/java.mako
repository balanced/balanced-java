% if mode == 'definition':
Refund.Collection = new Refund.Collection(String uri);

% else:
Refund.Collection refunds = new Refund.Collection("/v1/marketplaces/TEST-MP1cY43VkrOlypoTc5lxfstI/refunds");

% endif

