% if mode == 'definition':
Callback(Map<String, Object> payload)

% else:
Balanced.configure("ak-test-2cSDy37BKy5K4NUHKHVNXNTjTHPEqjRtB");

Callback callback = new Callback("http://www.example.com/callback");

try {
    callback.save();
}
catch(HTTPError e) {}

% endif

