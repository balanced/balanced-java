% if mode == 'definition':
Customer.addCard(String uri);

% else:
String apiKey = "2776ea40d92e11e29fe1026ba7cac9da";
String location = System.getProperty("balanced_location", Settings.location);
String key = System.getProperty("balanced_key", apiKey);
Settings.configure(location, key);

Customer customer = new Customer("/v1/customers/CU35EBvb9i2DsNqkuy96EGTI");
customer.addCard("/v1/marketplaces/TEST-MP1cY43VkrOlypoTc5lxfstI/cards/CC375O8m73xEg1AV1oL1AIe2");

% endif

