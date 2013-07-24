% if mode == 'definition':
Card.unstore();

% else:
Settings.configure("6f755804f3e111e295f6026ba7cd33d0");

Card card = new Card("");
try {
    card.unstore();
}
catch (NotCreated e) {
    // the card didn't exist in the first place
}

% endif

