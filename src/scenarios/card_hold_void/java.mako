% if mode == 'definition':
CardHold().unstore()

% else:
Balanced.configure("ak-test-1ByQgRpcQLTwmOhCBUofyIHm0r96qPm8s");

CardHold cardHold = new CardHold("/card_holds/HLKUg5lJJ5fQZpvaAujCWZH");
try {
    cardHold.unstore();
}
catch (HTTPError e) {}
catch (NotCreated notCreated) {}

% endif

