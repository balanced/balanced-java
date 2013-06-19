% if mode == 'definition':
Card.Collection cards = new Card.Collection(uri);

% else:
Card.Collection cards = new Card.Collection("/v1/marketplaces/TEST-MP1cY43VkrOlypoTc5lxfstI/cards");

% endif

