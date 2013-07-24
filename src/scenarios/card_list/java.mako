% if mode == 'definition':
Card.Collection cards = new Card.Collection(String uri);

% else:
Settings.configure("c07a8282f49111e2a035026ba7d31e6f");

Card.Collection cards = new Card.Collection("/v1/marketplaces/TEST-MP5Rwi1N0GqQZ9nAyf11c2v0/cards");

% endif

