% if mode == 'definition':
Callback(Map<String, Object> payload)

% else:
Balanced.configure("ak-test-2fYjkv4Tz5l3iPCtOlgLolmF15XPXlRCr");

HashMap<String, Object> payload = new HashMap<String, Object>();
payload.put("url", "http://www.example.com/callback");
payload.put("method", "post");

Callback callback = new Callback(payload);

try {
    callback.save();
}
catch (HTTPError e) {}

% endif

