% if mode == 'definition':
BankAccount.credit(int amount);

% else:
Balanced.configure("71d76c1223ad11e38848026ba7c1aba6");

BankAccount ba = new BankAccount("/v1/bank_accounts/BA43YHYoNLyuUUJ0VjZpKBpd");

Map<String, Object> payload = new HashMap<String, Object>();
payload.put("amount", 1000);

ba.credit(payload);

% endif

