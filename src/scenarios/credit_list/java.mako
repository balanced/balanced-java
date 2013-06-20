% if mode == 'definition':
Marketplace.credits;

% else:
String apiKey = "";
String location = System.getProperty("balanced_location", Settings.location);
String key = System.getProperty("balanced_key", apiKey);
Settings.configure(location, key);

Marketplace mp = Marketplace.mine();
Credit.Collection credits = mp.credits;

% endif

