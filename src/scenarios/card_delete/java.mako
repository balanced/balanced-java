% if mode == 'definition':
Card.unstore();

% else:
Settings.configure("2776ea40d92e11e29fe1026ba7cac9da");

Card card = new Card("");
try {
    card.unstore();
}
catch (NotCreated e) {
    // the card didn't exist in the first place
}

% endif

