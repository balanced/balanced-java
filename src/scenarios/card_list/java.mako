% if mode == 'definition':
Card.Collection cards = new Card.Collection(String uri);

% else:
Settings.configure("6f755804f3e111e295f6026ba7cd33d0");

Card.Collection cards = new Card.Collection("/v1/marketplaces/TEST-MP3oDYBxCRm2CVSWGt1RRctG/cards");

% endif

