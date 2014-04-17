% if mode == 'definition':
ApiKey(Map<String, Object> payload)

% else:
Balanced.configure("ak-test-2fYjkv4Tz5l3iPCtOlgLolmF15XPXlRCr");

ApiKey key = new ApiKey();
try {
    key.save();
}
catch (HTTPError e) {}

% endif

