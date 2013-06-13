% if mode == 'definition':
definition.tmpl
java.mako.tmpl
request.tmpl
Scenario.javaCard card = new Card();

% else:
    Event event = new Event("/v1/events/EV46e176b8cd8811e28d53026ba7cac9da");

% endif

