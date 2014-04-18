% if mode == 'definition':
ApiKey(Map<String, Object> payload)

% else:
Balanced.configure("ak-test-1ByQgRpcQLTwmOhCBUofyIHm0r96qPm8s");

ApiKey key = new ApiKey();
try {
    key.save();
}
catch (HTTPError e) {}

% endif

