% if mode == 'definition':
BankAccount().debit(Map<String, Object> payload)

% else:
Balanced.configure("ak-test-2cSDy37BKy5K4NUHKHVNXNTjTHPEqjRtB");

BankAccount bankAccount = new BankAccount("/bank_accounts/BA3EMnkybAfEzVlbVquXFLEk");

HashMap<String, Object> payload = new HashMap<String, Object>();
payload.put("amount", 5000);
payload.put("description", "Some descriptive text for the debit in the dashboard");
payload.put("appears_on_statement_as", "Statement text");

try {
    Debit debit = bankAccount.debit(payload);
}
catch (HTTPError e) {}

% endif

