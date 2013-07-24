% if mode == 'definition':
Callback.delete();

% else:
Settings.configure("6f755804f3e111e295f6026ba7cd33d0");

Callback callback = new Callback();
callback.save();
try {
    callback.delete();
}
catch (NotCreated e) {
    // the callback didn't exist in the first place
}

% endif

