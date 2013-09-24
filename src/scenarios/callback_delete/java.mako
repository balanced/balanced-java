% if mode == 'definition':
Callback.delete();

% else:
Settings.configure("71d76c1223ad11e38848026ba7c1aba6");

Callback callback = new Callback();
callback.save();
try {
    callback.delete();
}
catch (NotCreated e) {
    // the callback didn't exist in the first place
}

% endif

