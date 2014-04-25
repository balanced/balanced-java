% if mode == 'definition':
ApiKey().unstore()

% else:
Balanced.configure("ak-test-22IOkhevjZlmRP2do6CZixkkDshTiOjTV");

ApiKey key = new ApiKey("/api_keys/AK3DgZwSCD2ggxGSw1bsiyDX");
try {
    key.unstore();
}
catch (APIError e) {}
catch (NotCreated notCreated) {}

% endif

