% if mode == 'definition':
ApiKey(Map<String, Object> payload)

% else:
Balanced.configure("ak-test-2eKlj1ZDfAcZSARMf3NMhBHywDej0avSY");

ApiKey key = new ApiKey();
try {
    key.save();
}
catch (HTTPError e) {}

% endif

