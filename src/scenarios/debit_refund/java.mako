% if mode == 'definition':
definition.tmpl
java.mako.tmpl
request.tmpl
Scenario.javaCard card = new Card();

% else:
Map<String, Object> payload = new HashMap<String, Object>();
payload.put("card_number", );
payload.put("expiration_month", );
payload.put("expiration_year", );
payload.put("security_code", );
Card card = new Card(payload);
card.save();

% endif

