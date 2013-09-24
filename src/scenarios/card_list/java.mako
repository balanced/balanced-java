% if mode == 'definition':
Card.Collection cards = new Card.Collection(String uri);

% else:
Settings.configure("71d76c1223ad11e38848026ba7c1aba6");

Card.Collection cards = new Card.Collection("/v1/marketplaces/TEST-MP3t1UYs4ixXWfZ79kXhEUcy/cards");

% endif

