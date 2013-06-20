% if mode == 'definition':
Marketplace.credits;

% else:
String apiKey = "2776ea40d92e11e29fe1026ba7cac9da";
String location = System.getProperty("balanced_location", Settings.location);
String key = System.getProperty("balanced_key", apiKey);
Settings.configure(location, key);

Marketplace mp = Marketplace.mine();
Credit.Collection credits = mp.credits;

% endif

