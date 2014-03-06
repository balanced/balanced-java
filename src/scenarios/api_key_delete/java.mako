% if mode == 'definition':
ApiKey().unstore()

% else:
Balanced.configure("ak-test-2cSDy37BKy5K4NUHKHVNXNTjTHPEqjRtB");

ApiKey key = new ApiKey("/api_keys/AK3zUFsQ8aJ3aae9ZylavXLp");
try {
    key.unstore();
}
catch (APIError e) {}
catch (NotCreated notCreated) {}

% endif

