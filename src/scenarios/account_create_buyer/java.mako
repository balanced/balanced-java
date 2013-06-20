% if mode == 'definition':
Account.associateCard(String uri);

% else:
String apiKey = "2776ea40d92e11e29fe1026ba7cac9da";
String location = System.getProperty("balanced_location", Settings.location);
String key = System.getProperty("balanced_key", apiKey);
Settings.configure(location, key);

Account account = new Account("/v1/marketplaces/TEST-MP1cY43VkrOlypoTc5lxfstI/accounts");
account.associateCard("/v1/marketplaces/TEST-MP1cY43VkrOlypoTc5lxfstI/cards/CC3xtFSDTQORjXEFMTgP4HWu");

% endif

