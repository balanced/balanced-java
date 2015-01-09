% if mode == 'definition':
Card().unstore()

% else:
Balanced.configure("ak-test-1xLFE6RLC1W3P4ePiQDI4UVpRwtKcdfqL");

Card card = new Card("/cards/CC2SHYWrrAN9Vvl3vuznGeHu");
try {
    card.unstore();
}
catch (HTTPError e) {}
catch (NotCreated e) {}

% endif

