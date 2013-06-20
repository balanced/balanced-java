% if mode == 'definition':
Callback.delete();

% else:
Settings.configure("2776ea40d92e11e29fe1026ba7cac9da");

Callback callback = new Callback();
callback.save();
try {
    callback.delete();
}
catch (NotCreated e) {
    // the callback didn't exist in the first place
}

% endif

