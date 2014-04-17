% if mode == 'definition':
ApiKey().unstore()

% else:
Balanced.configure("ak-test-2fYjkv4Tz5l3iPCtOlgLolmF15XPXlRCr");

ApiKey key = new ApiKey("/api_keys/AK7EjZ7fq7gpLRj9HQNh12UE");
try {
    key.unstore();
}
catch (APIError e) {}
catch (NotCreated notCreated) {}

% endif

