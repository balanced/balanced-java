% if mode == 'definition':
Order().debitFrom(BankAccount bankAccount, Map<String, Object> payload)

% else:
Balanced.configure("ak-test-1xLFE6RLC1W3P4ePiQDI4UVpRwtKcdfqL");

BankAccount bankAccount = new BankAccount("/bank_accounts/BA3uzbngfVXy1SGg25Et7iKY");
Order order = new Order("/orders/OR5e6wrps4tp9QarDxWa01O5");

HashMap<String, Object> payload = new HashMap<String, Object>();
payload.put("amount", 5000);

try {
    Debit debit = order.debitFrom(bankAccount, payload);
}
catch (HTTPError e) {}

% endif

