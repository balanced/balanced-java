% if mode == 'definition':
CardHold().save()

% else:
Balanced.configure("ak-test-22IOkhevjZlmRP2do6CZixkkDshTiOjTV");

CardHold cardHold = new CardHold("/card_holds/HL4bdnO7ELS2JfyJ2T8elYOl");
cardHold.description = "update this description";
try {
    cardHold.save();
}
catch (HTTPError e) {}

% endif

