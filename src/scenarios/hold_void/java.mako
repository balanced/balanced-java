% if mode == 'definition':


% else:
String apiKey = "";
String location = System.getProperty("balanced_location", Settings.location);
String key = System.getProperty("balanced_key", apiKey);
Settings.configure(location, key);

Hold hold = new Hold("/v1/marketplaces/TEST-MP1cY43VkrOlypoTc5lxfstI/holds/HL2NUpy8jaBA1rvSpIR4gQtM");
hold.is_void = true;
hold.save();

% endif

