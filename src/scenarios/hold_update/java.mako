% if mode == 'definition':
Hold.save();

% else:
String apiKey = "2776ea40d92e11e29fe1026ba7cac9da";
String location = System.getProperty("balanced_location", Settings.location);
String key = System.getProperty("balanced_key", apiKey);
Settings.configure(location, key);

Hold hold = new Hold("/v1/marketplaces/TEST-MP1cY43VkrOlypoTc5lxfstI/holds/HL2c934i8dnd0nydSAXhhbdI");
hold.description = "update this description";
hold.save();

% endif

