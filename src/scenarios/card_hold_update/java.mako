% if mode == 'definition':
CardHold().save()

% else:
Balanced.configure("ak-test-1xLFE6RLC1W3P4ePiQDI4UVpRwtKcdfqL");

CardHold cardHold = new CardHold("/card_holds/HL44qbPoom3uVlTlEGBZV7z2");
cardHold.description = "update this description";
try {
    cardHold.save();
}
catch (HTTPError e) {}

% endif

