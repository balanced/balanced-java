% if mode == 'definition':
Account.credits;

% else:
String apiKey = "2776ea40d92e11e29fe1026ba7cac9da";
String location = System.getProperty("balanced_location", Settings.location);
String key = System.getProperty("balanced_key", apiKey);
Settings.configure(location, key);

Account account = new Account("/v1/bank_accounts/BA1iViFZ5fKWIixl3fpq07Je");
Credit.Collection credits = account.credits;

% endif

