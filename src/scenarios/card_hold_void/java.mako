% if mode == 'definition':
CardHold().unstore()

% else:
Balanced.configure("ak-test-2fYjkv4Tz5l3iPCtOlgLolmF15XPXlRCr");

CardHold cardHold = new CardHold("/card_holds/HLjSXY6l7UHGZD9v0YIbNHM");
try {
    cardHold.unstore();
}
catch (HTTPError e) {}
catch (NotCreated notCreated) {}

% endif

