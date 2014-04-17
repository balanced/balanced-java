% if mode == 'definition':
Card().unstore()

% else:
Balanced.configure("ak-test-2fYjkv4Tz5l3iPCtOlgLolmF15XPXlRCr");

Card card = new Card("/cards/CCA3crun7LbUPTtQyJhPAtW");
try {
    card.unstore();
}
catch (HTTPError e) {}
catch (NotCreated e) {}

% endif

