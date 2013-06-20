% if mode == 'definition':
Account.hold(int amount);

% else:
String apiKey = "";
String location = System.getProperty("balanced_location", Settings.location);
String key = System.getProperty("balanced_key", apiKey);
Settings.configure(location, key);

Account account = new Account("/v1/marketplaces/TEST-MP1cY43VkrOlypoTc5lxfstI/accounts/AC3z3msdgTHiowL349h94P22");
Hold hold = account.hold(100);

% endif

