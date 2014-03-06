% if mode == 'definition':
CardHold().save()

% else:
Balanced.configure("ak-test-2cSDy37BKy5K4NUHKHVNXNTjTHPEqjRtB");

CardHold cardHold = new CardHold("/card_holds/HL4a1BKhDiVV9Ueh9MTozVDs");
cardHold.description = "update this description";
cardHold.save();

% endif

