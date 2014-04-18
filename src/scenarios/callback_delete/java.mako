% if mode == 'definition':
Callback().delete()

% else:
Balanced.configure("ak-test-1ByQgRpcQLTwmOhCBUofyIHm0r96qPm8s");

Callback callback = new Callback("/callbacks/CBwxLHWPLsoBqKqVyUvZRKp");

try {
    callback.delete();
}
catch (APIError e) {}
catch (NotCreated e) {}

% endif

