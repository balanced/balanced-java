% if mode == 'definition':
CardHold().unstore()

% else:
Balanced.configure("ak-test-1xLFE6RLC1W3P4ePiQDI4UVpRwtKcdfqL");

CardHold cardHold = new CardHold("/card_holds/HL2LGQraRykRR3IhnNGqdSNi");
try {
    cardHold.unstore();
}
catch (HTTPError e) {}
catch (NotCreated notCreated) {}

% endif

