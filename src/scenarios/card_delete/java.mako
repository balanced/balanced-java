% if mode == 'definition':
Card().unstore()

% else:
Balanced.configure("ak-test-25ZY8HQwZPuQtDecrxb671LilUya5t5G0");

Card card = new Card("/cards/CC33DRVrekWpiHYjxSdVuqWc");
try {
    card.unstore();
}
catch (HTTPError e) {}
catch (NotCreated e) {}

% endif

