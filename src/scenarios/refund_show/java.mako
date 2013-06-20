% if mode == 'definition':
Refund refund = new Refund(String uri);

% else:
String apiKey = "";
String location = System.getProperty("balanced_location", Settings.location);
String key = System.getProperty("balanced_key", apiKey);
Settings.configure(location, key);

Refund refund = new Refund("/v1/marketplaces/TEST-MP1cY43VkrOlypoTc5lxfstI/refunds/RF2Tl2Zvpxlib5YgfpfcHGHl");

% endif

