% if mode == 'definition':
Card.save();

% else:
String apiKey = "2776ea40d92e11e29fe1026ba7cac9da";
String location = System.getProperty("balanced_location", Settings.location);
String key = System.getProperty("balanced_key", apiKey);
Settings.configure(location, key);

Card card = new Card("/v1/marketplaces/TEST-MP1cY43VkrOlypoTc5lxfstI/cards/CC1urjr8nECMDtdzPr1ByVZu");
Map<String, String> meta = new HashMap<String, String>();
meta.put("facebook.user_id", "0192837465");
meta.put("my-own-customer-id", "12345");
meta.put("twitter.id", "1234987650");
card.meta = meta;
card.save();


% endif

