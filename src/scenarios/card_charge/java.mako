% if mode == 'definition':
Card.Collection cards = new Card.Collection(String uri);

% else:
Settings.configure("2776ea40d92e11e29fe1026ba7cac9da");

Card.Collection cards = new Card.Collection("/v1/marketplaces/TEST-MP1cY43VkrOlypoTc5lxfstI/cards");

% endif

