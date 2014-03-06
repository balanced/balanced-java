% if mode == 'definition':
ApiKey(Map<String, Object> payload)

% else:
Balanced.configure("ak-test-2cSDy37BKy5K4NUHKHVNXNTjTHPEqjRtB");

ApiKey key = new ApiKey();
try {
    key.save();
}
catch (HTTPError e) {}

% endif

