% if mode == 'definition':
CardHold().save()

% else:
Balanced.configure("ak-test-2fYjkv4Tz5l3iPCtOlgLolmF15XPXlRCr");

CardHold cardHold = new CardHold("/card_holds/HLbr4hg4i7Mg2wAEroOwJhk");
cardHold.description = "update this description";
try {
    cardHold.save();
}
catch (HTTPError e) {}

% endif

