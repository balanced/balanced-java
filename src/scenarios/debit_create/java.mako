% if mode == 'definition':
Account.debit(int amount,
String description,
String source_uri,
String appears_on_statement_as,
Map<String, String> meta);

% else:
String apiKey = "";
String location = System.getProperty("balanced_location", Settings.location);
String key = System.getProperty("balanced_key", apiKey);
Settings.configure(location, key);

Account account = new Account("/v1/marketplaces/TEST-MP1cY43VkrOlypoTc5lxfstI/accounts/AC1DOd9xMVGdZSGUeyrducwU");
account.debit(5000,
              "Some descriptive text for the debit in the dashboard",
              "/v1/marketplaces/TEST-MP1cY43VkrOlypoTc5lxfstI/accounts/AC1DOd9xMVGdZSGUeyrducwU",
              "Statement text",
              null);

% endif

