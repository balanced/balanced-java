% if mode == 'definition':
Card card = new Card();

% else:
Hold hold = new Hold("/v1/marketplaces/TEST-MP1cY43VkrOlypoTc5lxfstI/holds/HL2NUpy8jaBA1rvSpIR4gQtM");
hold.is_void = true;
hold.save();

% endif

