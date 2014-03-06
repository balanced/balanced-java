% if mode == 'definition':
Callback().delete()

% else:
Balanced.configure("ak-test-2cSDy37BKy5K4NUHKHVNXNTjTHPEqjRtB");

Callback callback = new Callback("/callbacks/CB40OMtABWHqkGcBEYpWVnAd");

try {
    callback.delete();
}
catch (APIError e) {}
catch (NotCreated e) {}

% endif

