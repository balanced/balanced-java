% if mode == 'definition':
Callback.delete();

% else:
Settings.configure("c07a8282f49111e2a035026ba7d31e6f");

Callback callback = new Callback();
callback.save();
try {
    callback.delete();
}
catch (NotCreated e) {
    // the callback didn't exist in the first place
}

% endif

