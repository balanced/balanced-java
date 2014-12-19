% if mode == 'definition':
CardHold().save()

% else:
Balanced.configure("ak-test-2wIOi20ITgc1u1Lw6UM3y5ZZjZ66M8HMf");

CardHold cardHold = new CardHold("/card_holds/HL5gGjFGvSfw0pkPB93SnYze");
cardHold.description = "update this description";
try {
    cardHold.save();
}
catch (HTTPError e) {}

% endif

