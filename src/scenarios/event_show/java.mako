% if mode == 'definition':
Event event = new Event(String uri);

% else:
String apiKey = "";
String location = System.getProperty("balanced_location", Settings.location);
String key = System.getProperty("balanced_key", apiKey);
Settings.configure(location, key);

Event event = new Event("/v1/events/EV27be46ecd92e11e296f4026ba7cac9da");

% endif

