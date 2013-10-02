% if mode == 'definition':
Card.unstore();

% else:
Settings.configure("c07a8282f49111e2a035026ba7d31e6f");

Card card = new Card("");
try {
    card.unstore();
}
catch (NotCreated e) {
    // the card didn't exist in the first place
}

% endif

