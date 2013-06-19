% if mode == 'definition':
Card.Collection cards = new Card.Collection(uri);

% else:
Card.Collection cards = new Card.Collection("/v1/marketplaces/TEST-MP3MuCwscFiUbhv2Z2lB49cQ/cards");

% endif

