% if mode == 'definition':
Callback(String uri);

% else:
String apiKey = "";
String location = System.getProperty("balanced_location", Settings.location);
String key = System.getProperty("balanced_key", apiKey);
Settings.configure(location, key);

Callback callback = new Callback();
callback.save();

% endif

