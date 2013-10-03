% if mode == 'definition':
Callback.delete();

% else:
Balanced.configure("ak-test-2ppXve1BnInnsIKZytspDrsuhjtAT9dD8");

Callback callback = new Callback();
callback.save();
try {
    callback.delete();
}
catch (NotCreated e) {
    // the callback didn't exist in the first place
}

% endif

