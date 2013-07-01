% if mode == 'definition':
Card.unstore();

% else:
Settings.configure("2776ea40d92e11e29fe1026ba7cac9da");

Card card = new Card("/v1/marketplaces/TEST-MP1cY43VkrOlypoTc5lxfstI/cards/CC1urjr8nECMDtdzPr1ByVZu");
try {
    card.unstore();
}
catch (NotCreated e) {
    // the card didn't exist in the first place
}

% endif

