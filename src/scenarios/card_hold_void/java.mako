% if mode == 'definition':
CardHold().unstore()

% else:
Balanced.configure("ak-test-2eKlj1ZDfAcZSARMf3NMhBHywDej0avSY");

CardHold cardHold = new CardHold("/card_holds/HL4u4T2877PfgYwnbhD2XweV");
try {
    cardHold.unstore();
}
catch (HTTPError e) {}
catch (NotCreated notCreated) {}

% endif

