% if mode == 'definition':
Callback(Map<String, Object> payload)

% else:
Balanced.configure("ak-test-2cSDy37BKy5K4NUHKHVNXNTjTHPEqjRtB");

HashMap<String, Object> payload = new HashMap<String, Object>();
payload.put("url", "http://www.example.com/callback");
payload.put("method", "");

Callback callback = new Callback(payload);

try {
    callback.save();
}
catch (HTTPError e) {}

% endif

