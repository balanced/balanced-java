% if mode == 'definition':
CardHold().save()

% else:
Balanced.configure("ak-test-1ByQgRpcQLTwmOhCBUofyIHm0r96qPm8s");

CardHold cardHold = new CardHold("/card_holds/HLqY5FcrUWcnBzMkHpKK1WB");
cardHold.description = "update this description";
try {
    cardHold.save();
}
catch (HTTPError e) {}

% endif

