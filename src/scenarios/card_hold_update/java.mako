% if mode == 'definition':
CardHold().save()

% else:
Balanced.configure("ak-test-2eKlj1ZDfAcZSARMf3NMhBHywDej0avSY");

CardHold cardHold = new CardHold("/card_holds/HL4iHX8OBNW7nVsu6MqyjnQ9");
cardHold.description = "update this description";
try {
    cardHold.save();
}
catch (HTTPError e) {}

% endif

