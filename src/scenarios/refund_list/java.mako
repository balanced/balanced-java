% if mode == 'definition':
Refund.Collection = new Refund.Collection(String uri);

% else:
String apiKey = "";
String location = System.getProperty("balanced_location", Settings.location);
String key = System.getProperty("balanced_key", apiKey);
Settings.configure(location, key);

Refund.Collection refunds = new Refund.Collection("/v1/marketplaces/TEST-MP1cY43VkrOlypoTc5lxfstI/refunds");

% endif

