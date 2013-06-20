% if mode == 'definition':
Event.Collection(String uri);

% else:
Event.Collection events = new Event.Collection("/v1/events");

% endif

