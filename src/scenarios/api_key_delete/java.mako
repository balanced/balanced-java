% if mode == 'definition':
ApiKey().unstore()

% else:
Balanced.configure("ak-test-1xLFE6RLC1W3P4ePiQDI4UVpRwtKcdfqL");

ApiKey key = new ApiKey("/api_keys/AK5GPcrSGuD1jtq6cEctwa3j");
try {
    key.unstore();
}
catch (APIError e) {}
catch (NotCreated notCreated) {}

% endif

