% if mode == 'definition':
ApiKey().unstore()

% else:
Balanced.configure("ak-test-2eKlj1ZDfAcZSARMf3NMhBHywDej0avSY");

ApiKey key = new ApiKey("/api_keys/AK3DQGzROuoRYulKXMQdHBxX");
try {
    key.unstore();
}
catch (APIError e) {}
catch (NotCreated notCreated) {}

% endif

