% if mode == 'definition':
Card().unstore()

% else:
Balanced.configure("ak-test-2cSDy37BKy5K4NUHKHVNXNTjTHPEqjRtB");

Card card = new Card("/cards/CC4cbNzUmFqGrc1GmFpXp6fe");
try {
    card.unstore();
}
catch (HTTPError e) {}
catch (NotCreated e) {}

% endif

