% if mode == 'definition':
ApiKey().unstore()

% else:
Balanced.configure("ak-test-1ByQgRpcQLTwmOhCBUofyIHm0r96qPm8s");

ApiKey key = new ApiKey("/api_keys/AK7KGjv4YKtOf03Lqm0f84V");
try {
    key.unstore();
}
catch (APIError e) {}
catch (NotCreated notCreated) {}

% endif

