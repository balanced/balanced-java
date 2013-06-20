% if mode == 'definition':
Debit.Collection(String uri);

% else:
String apiKey = "";
String location = System.getProperty("balanced_location", Settings.location);
String key = System.getProperty("balanced_key", apiKey);
Settings.configure(location, key);

Debit.Collection debits = new Debit.Collection("/v1/marketplaces/TEST-MP1cY43VkrOlypoTc5lxfstI/debits");

% endif

