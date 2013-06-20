% if mode == 'definition':
Refund.save();

% else:
String apiKey = "";
String location = System.getProperty("balanced_location", Settings.location);
String key = System.getProperty("balanced_key", apiKey);
Settings.configure(location, key);

Refund refund = new Refund("/v1/marketplaces/TEST-MP1cY43VkrOlypoTc5lxfstI/refunds/RF2Tl2Zvpxlib5YgfpfcHGHl");

Map<String, String> meta = new HashMap<String, String>();
meta.put("refund.reason", "user not happy with product");
meta.put("user.notes", "very polite on the phone");
meta.put("user.refund.count", "3");
refund.meta = meta;
refund.description = "update this description";
refund.save();


% endif

