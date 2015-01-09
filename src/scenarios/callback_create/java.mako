% if mode == 'definition':
Callback(Map<String, Object> payload)

% else:
Balanced.configure("ak-test-2eKlj1ZDfAcZSARMf3NMhBHywDej0avSY");

HashMap<String, Object> payload = new HashMap<String, Object>();
payload.put("url", "http://www.example.com/callback_test");
payload.put("method", "post");

Callback callback = new Callback(payload);

try {
    callback.save();
}
catch (HTTPError e) {}

% endif

