% if mode == 'definition':
Callback.delete();

% else:
Callback callback = new Callback();
callback.save();
try {
    callback.delete();
}
catch (NotCreated e) {
    // the callback didn't exist in the first place
}

% endif

