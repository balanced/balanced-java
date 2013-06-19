% if mode == 'definition':
Hold.capture(Map<String, Object> payload);

% else:
Map<String, Object> payload = new HashMap<String, Object>();
payload.put("hold_uri", "/v1/marketplaces/TEST-MP3MuCwscFiUbhv2Z2lB49cQ/holds/HL10OYZ6boBE6q4MtcMFjrce");
payload.put("amount", 1000);
Hold hold = new Hold(payload);
hold.account_uri = "/v1/marketplaces/TEST-MP3MuCwscFiUbhv2Z2lB49cQ/accounts/AC5ToiF5k1RCPNOfiPXAvNPk";
Account account = hold.getAccount();
Debit debit = hold.capture(1000);

% endif

