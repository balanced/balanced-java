% if mode == 'definition':
Card().unstore()

% else:
Balanced.configure("ak-test-2eKlj1ZDfAcZSARMf3NMhBHywDej0avSY");

Card card = new Card("/cards/CC4zyuNpxY0A0eAf87SeULCR");
try {
    card.unstore();
}
catch (HTTPError e) {}
catch (NotCreated e) {}

% endif

