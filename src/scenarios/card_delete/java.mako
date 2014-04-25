% if mode == 'definition':
Card().unstore()

% else:
Balanced.configure("ak-test-22IOkhevjZlmRP2do6CZixkkDshTiOjTV");

Card card = new Card("/cards/CC4mYF7dj7X6OA2K5F0Qyb4N");
try {
    card.unstore();
}
catch (HTTPError e) {}
catch (NotCreated e) {}

% endif

