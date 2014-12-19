% if mode == 'definition':
ApiKey().unstore()

% else:
Balanced.configure("ak-test-2wIOi20ITgc1u1Lw6UM3y5ZZjZ66M8HMf");

ApiKey key = new ApiKey("/api_keys/AK4e2JjsmVYES9oUwqRYg8hy");
try {
    key.unstore();
}
catch (APIError e) {}
catch (NotCreated notCreated) {}

% endif

