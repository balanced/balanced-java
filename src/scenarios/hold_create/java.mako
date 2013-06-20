% if mode == 'definition':
Account.hold(
    int amount,
    String description,
    String source_uri,
    Map<String, String> meta)

% else:
String apiKey = "2776ea40d92e11e29fe1026ba7cac9da";
String location = System.getProperty("balanced_location", Settings.location);
String key = System.getProperty("balanced_key", apiKey);
Settings.configure(location, key);

Account account = new Account("/v1/marketplaces/TEST-MP1cY43VkrOlypoTc5lxfstI/accounts/AC1DOd9xMVGdZSGUeyrducwU");
account.hold( 5000,
"Some descriptive text for the debit in the dashboard",
"",
null);
account.save();

% endif

