% if mode == 'definition':
Hold.capture(Map<String, Object> payload);

% else:
Settings.configure("6f755804f3e111e295f6026ba7cd33d0");

Map<String, Object> payload = new HashMap<String, Object>();
payload.put("hold_uri", "/v1/marketplaces/TEST-MP3oDYBxCRm2CVSWGt1RRctG/holds/HL5bwm0BZqSgS4LgieEb1G7A");
payload.put("amount", 1000);
Hold hold = new Hold(payload);
hold.account_uri = "/v1/marketplaces/TEST-MP3oDYBxCRm2CVSWGt1RRctG/accounts/AC52P298OJQArx1rVOrsVNfG";
Account account = hold.getAccount();
Debit debit = hold.capture(1000);

% endif

