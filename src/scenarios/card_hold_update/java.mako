% if mode == 'definition':
CardHold().save()

% else:
Balanced.configure("ak-test-25ZY8HQwZPuQtDecrxb671LilUya5t5G0");

CardHold cardHold = new CardHold("/card_holds/HL2F8jlnySjVKidwfXgBYZMY");
cardHold.description = "update this description";
try {
    cardHold.save();
}
catch (HTTPError e) {}

% endif

