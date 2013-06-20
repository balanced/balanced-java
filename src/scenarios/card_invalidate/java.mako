% if mode == 'definition':

% else:
String apiKey = "";
String location = System.getProperty("balanced_location", Settings.location);
String key = System.getProperty("balanced_key", apiKey);
Settings.configure(location, key);

Card card = new Card("/v1/marketplaces/TEST-MP1cY43VkrOlypoTc5lxfstI/cards/CC1urjr8nECMDtdzPr1ByVZu");
card.is_valid = false;
card.save();

% endif

