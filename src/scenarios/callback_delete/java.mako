% if mode == 'definition':
Callback().delete()

% else:
Balanced.configure("ak-test-2fYjkv4Tz5l3iPCtOlgLolmF15XPXlRCr");

Callback callback = new Callback("/callbacks/CB6K21Z5b8imJRPeZEBoHPq");

try {
    callback.delete();
}
catch (APIError e) {}
catch (NotCreated e) {}

% endif

