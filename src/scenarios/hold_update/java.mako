% if mode == 'definition':
Hold.save();

% else:
Hold hold = new Hold("/v1/marketplaces/TEST-MP1cY43VkrOlypoTc5lxfstI/holds/HL2c934i8dnd0nydSAXhhbdI");
hold.description = "update this description";
hold.save();

% endif

