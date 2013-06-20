% if mode == 'definition':
Callback(String uri);

% else:
Callback callback = new Callback();
callback.save();

% endif

