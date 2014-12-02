% if mode == 'definition':
ApiKey().unstore()

% else:
Balanced.configure("ak-test-25ZY8HQwZPuQtDecrxb671LilUya5t5G0");

ApiKey key = new ApiKey("/api_keys/AKJnLWedoBhUHpdhoGEOPew");
try {
    key.unstore();
}
catch (APIError e) {}
catch (NotCreated notCreated) {}

% endif

