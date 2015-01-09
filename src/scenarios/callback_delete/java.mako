% if mode == 'definition':
Callback().delete()

% else:
Balanced.configure("ak-test-1xLFE6RLC1W3P4ePiQDI4UVpRwtKcdfqL");

Callback callback = new Callback("/callbacks/CB3BP8jjVy8RBUFdb2fYw0mh");

try {
    callback.delete();
}
catch (APIError e) {}
catch (NotCreated e) {}

% endif

