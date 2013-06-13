% if mode == 'definition':
definition.tmpl
java.mako.tmpl
request.tmpl
Scenario.javaCard card = new Card();

% else:
    Event event = new Event("/v1/events/EVc75db820d3ae11e29834026ba7cac9da");

% endif

