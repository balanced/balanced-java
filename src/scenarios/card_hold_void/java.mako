% if mode == 'definition':
CardHold().unstore()

% else:
Balanced.configure("ak-test-2cSDy37BKy5K4NUHKHVNXNTjTHPEqjRtB");

CardHold cardHold = new CardHold("/card_holds/HL4fmk2370zAE7nAVujKxjtf");
try {
    cardHold.unstore();
}
catch (HTTPError e) {}
catch (NotCreated notCreated) {}

% endif

