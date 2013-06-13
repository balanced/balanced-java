% if mode == 'definition':
    Card.Collection cards = new Card.Collection(uri);

% else:
    Card.Collection cards = new Card.Collection("/v1/marketplaces/TEST-MP29J5STPtZVvnjAFndM0N62/cards");

% endif

