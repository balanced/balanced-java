% if mode == 'definition':
Credit credit = new Credit(String uri);

% else:
String apiKey = "";
String location = System.getProperty("balanced_location", Settings.location);
String key = System.getProperty("balanced_key", apiKey);
Settings.configure(location, key);

Credit credit = new Credit("/v1/credits/CR1S0Lm10SbeviGMt1Xxosq3");

% endif

