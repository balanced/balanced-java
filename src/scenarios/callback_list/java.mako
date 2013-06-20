% if mode == 'definition':
Callback.Collection(String uri);

% else:
String apiKey = "";
String location = System.getProperty("balanced_location", Settings.location);
String key = System.getProperty("balanced_key", apiKey);
Settings.configure(location, key);

Callback.Collection callbacks = new Callback.Collection("");

% endif

