% if mode == 'definition':
BankAccount().save()

% else:
Balanced.configure("ak-test-25ZY8HQwZPuQtDecrxb671LilUya5t5G0");

BankAccount bankAccount = new BankAccount("/bank_accounts/BA1D19WqGc3j78IAhFIkasQd");

Map<String, String> meta = new HashMap<String, String>();
meta.put("facebook.user_id", "0192837465");
meta.put("my-own-customer-id", "12345");
meta.put("twitter.id", "1234987650");

bankAccount.meta = meta;

try {
    bankAccount.save();
}
catch (HTTPError e) {}



% endif

