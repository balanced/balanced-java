% if mode == 'definition':
BankAccount().credit(Map<String, Object> payload)

% else:
Balanced.configure("ak-test-1xLFE6RLC1W3P4ePiQDI4UVpRwtKcdfqL");

BankAccount bankAccount = new BankAccount("/bank_accounts/BA6g0aWJb8TNd7sXXs17t0Q0");

HashMap<String, Object> payload = new HashMap<String, Object>();
payload.put("amount", 5000);

try {
    Credit credit = bankAccount.credit(payload);
}
catch (HTTPError e) {}

% endif

