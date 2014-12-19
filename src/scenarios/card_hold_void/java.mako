% if mode == 'definition':
CardHold().unstore()

% else:
Balanced.configure("ak-test-2wIOi20ITgc1u1Lw6UM3y5ZZjZ66M8HMf");

CardHold cardHold = new CardHold("/card_holds/HL5usZqQ94C25Cv0kmFDJYZD");
try {
    cardHold.unstore();
}
catch (HTTPError e) {}
catch (NotCreated notCreated) {}

% endif

