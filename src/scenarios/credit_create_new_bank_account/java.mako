% if mode == 'definition':
BankAccount.credit(Map<String, Object> payload)

% else:
Balanced.configure("ak-test-2fYjkv4Tz5l3iPCtOlgLolmF15XPXlRCr");
/*
Map<String, Object> bankAccountPayload = new HashMap<String, Object>();
bankAccountPayload.put("name", "");
bankAccountPayload.put("routing_number", "");
bankAccountPayload.put("account_number", "");
bankAccountPayload.put("type", "");

Map<String, Object> payload = new HashMap<String, Object>();
payload.put("amount", );
payload.put("bank_account", bankAccountPayload);

Credit credit = new Credit(payload);
credit.save();
*/

% endif

