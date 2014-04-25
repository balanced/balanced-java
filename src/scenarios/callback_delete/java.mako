% if mode == 'definition':
Callback().delete()

% else:
Balanced.configure("ak-test-22IOkhevjZlmRP2do6CZixkkDshTiOjTV");

Callback callback = new Callback("/callbacks/CB44XaMOcxsUnuQoA5A4VKCx");

try {
    callback.delete();
}
catch (APIError e) {}
catch (NotCreated e) {}

% endif

