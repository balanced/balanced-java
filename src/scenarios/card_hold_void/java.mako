% if mode == 'definition':
CardHold().unstore()

% else:
Balanced.configure("ak-test-22IOkhevjZlmRP2do6CZixkkDshTiOjTV");

CardHold cardHold = new CardHold("/card_holds/HL4joUazeM3BJE6emmv2Q8EF");
try {
    cardHold.unstore();
}
catch (HTTPError e) {}
catch (NotCreated notCreated) {}

% endif

