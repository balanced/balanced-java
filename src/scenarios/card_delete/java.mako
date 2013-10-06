% if mode == 'definition':
Card.unstore()

% else:
Balanced.configure("ak-test-1p1Tsac7gHeMQowL2seB7ieliuAJAufyq");

Card card = new Card("/v1/marketplaces/TEST-MP5FKPQwyjvVgTDt7EiRw3Kq/cards/CC6NiW8huZV4AxYTDJsjOd7k");
try {
    card.unstore();
}
catch (NotCreated e) {
    // the card didn't exist in the first place
}

% endif

