% if mode == 'definition':
CardHold().unstore()

% else:
Balanced.configure("ak-test-25ZY8HQwZPuQtDecrxb671LilUya5t5G0");

CardHold cardHold = new CardHold("/card_holds/HL2U14YhpFdRACfJzlQNFI7m");
try {
    cardHold.unstore();
}
catch (HTTPError e) {}
catch (NotCreated notCreated) {}

% endif

