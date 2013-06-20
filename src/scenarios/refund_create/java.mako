% if mode == 'definition':
Debit.refund();

% else:
String apiKey = "";
String location = System.getProperty("balanced_location", Settings.location);
String key = System.getProperty("balanced_key", apiKey);
Settings.configure(location, key);

Debit debit = new Debit("/v1/marketplaces/TEST-MP1cY43VkrOlypoTc5lxfstI/debits/WD2S3Z2JJWKzMvFZccxqZ0C4");
debit.refund();

% endif

