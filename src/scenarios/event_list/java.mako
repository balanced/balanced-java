% if mode == 'definition':
Event.Collection(String uri);

% else:
String apiKey = "";
String location = System.getProperty("balanced_location", Settings.location);
String key = System.getProperty("balanced_key", apiKey);
Settings.configure(location, key);

Event.Collection events = new Event.Collection("/v1/events");

% endif

