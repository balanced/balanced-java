% if mode == 'definition':
Callback().delete()

% else:
Balanced.configure("ak-test-25ZY8HQwZPuQtDecrxb671LilUya5t5G0");

Callback callback = new Callback("/callbacks/CB2xCnObyAUU1V658GVuRyCI");

try {
    callback.delete();
}
catch (APIError e) {}
catch (NotCreated e) {}

% endif

