% if mode == 'definition':
BankAccount().credit(Map<String, Object> payload)

% else:
Balanced.configure("ak-test-2cSDy37BKy5K4NUHKHVNXNTjTHPEqjRtB");

BankAccount bankAccount = new BankAccount("/bank_accounts/BA4JCiiAb4alhWMlZSv9POAU");

HashMap<String, Object> payload = new HashMap<String, Object>();
payload.put("amount", 5000);

try {
    Credit credit = bankAccount.credit(payload);
}
catch (HTTPError e) {}

% endif

