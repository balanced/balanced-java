% if mode == 'definition':
Refund.Collection = new Refund.Collection(String uri);

% else:
Settings.configure("2776ea40d92e11e29fe1026ba7cac9da");

Refund.Collection refunds = new Refund.Collection("/v1/marketplaces/TEST-MP1cY43VkrOlypoTc5lxfstI/refunds");

% endif

