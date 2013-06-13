% if mode == 'definition':
Card card = new Card();

% else:
    Event.Collection events = new Event.Collection("/v1/events");

% endif

