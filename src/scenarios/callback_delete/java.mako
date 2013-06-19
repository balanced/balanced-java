% if mode == 'definition':
Callback.delete();

% else:
Callback callback = new Callback();
callback.save();
callback.delete();

% endif

