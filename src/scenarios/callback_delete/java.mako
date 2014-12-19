% if mode == 'definition':
Callback().delete()

% else:
Balanced.configure("ak-test-2wIOi20ITgc1u1Lw6UM3y5ZZjZ66M8HMf");

Callback callback = new Callback("/callbacks/CB52j36ilEVeALiL9ABZ0Jl6");

try {
    callback.delete();
}
catch (APIError e) {}
catch (NotCreated e) {}

% endif

