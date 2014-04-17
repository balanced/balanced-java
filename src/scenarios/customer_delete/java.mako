% if mode == 'definition':
Customer().unstore()

% else:
Balanced.configure("ak-test-2fYjkv4Tz5l3iPCtOlgLolmF15XPXlRCr");

Customer customer = new Customer("/customers/CU116TOiXnCfxHyDErDcMtpU");

try {
    customer.unstore();
}
catch (HTTPError e) {}
catch (NotCreated e) {}

% endif

