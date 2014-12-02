% if mode == 'definition':
Order().debitFrom(BankAccount bankAccount, Map<String, Object> payload)

% else:
Balanced.configure("ak-test-25ZY8HQwZPuQtDecrxb671LilUya5t5G0");

BankAccount bankAccount = new BankAccount("/bank_accounts/BA17zYxBNrmg9isvicjz9Ae4");
Order order = new Order("/orders/OR5sl2RJVnbwEf45nq5eATdz");

HashMap<String, Object> payload = new HashMap<String, Object>();
payload.put("amount", 5000);

try {
    Debit debit = order.debitFrom(bankAccount, payload);
}
catch (HTTPError e) {}

% endif

