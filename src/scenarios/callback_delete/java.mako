% if mode == 'definition':
Callback.delete()

% else:
Balanced.configure("ak-test-1p1Tsac7gHeMQowL2seB7ieliuAJAufyq");

Callback callback = new Callback("/v1/callbacks/CB6DYHGJOCaSxYwDz34j5TGa");

try {
    callback.delete();
}
catch (NotCreated e) {
    // the callback didn't exist in the first place
}

% endif

