% if mode == 'definition':
Hold.capture(Map<String, Object> payload);

% else:
Settings.configure("2776ea40d92e11e29fe1026ba7cac9da");

Map<String, Object> payload = new HashMap<String, Object>();
payload.put("hold_uri", "/v1/marketplaces/TEST-MP1cY43VkrOlypoTc5lxfstI/holds/HL3IKFgbk6IzYg4IhOjzzjTp");
payload.put("amount", 1000);
Hold hold = new Hold(payload);
hold.account_uri = "/v1/marketplaces/TEST-MP1cY43VkrOlypoTc5lxfstI/accounts/AC3z3msdgTHiowL349h94P22";
Account account = hold.getAccount();
Debit debit = hold.capture(1000);

% endif

