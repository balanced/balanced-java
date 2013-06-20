% if mode == 'definition':
BankAccount.credit(int amount);

% else:
String apiKey = "2776ea40d92e11e29fe1026ba7cac9da";
String location = System.getProperty("balanced_location", Settings.location);
String key = System.getProperty("balanced_key", apiKey);
Settings.configure(location, key);

BankAccount ba = new BankAccount();
ba.account_number = "9900000003";
ba.name = "Johann Bernoulli";
ba.routing_number = "121000358";
ba.type = "checking";
ba.save();
ba.credit(10000);

% endif

