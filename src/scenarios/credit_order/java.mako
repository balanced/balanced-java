% if mode == 'definition':
Order().creditTo(BankAccount bankAccount, Map<String, Object> payload)

% else:
Balanced.configure("ak-test-25ZY8HQwZPuQtDecrxb671LilUya5t5G0");

BankAccount bankAccount = new BankAccount("/bank_accounts/BA2gul8YMjFWnFk0fFHXwX6g/credits");
Order order = new Order("/orders/OR3BXTqXewuSy1Cu3g6N2Sjj");

HashMap<String, Object> payload = new HashMap<String, Object>();
payload.put("amount", 5000);

try {
    Credit credit = order.creditTo(bankAccount, payload);
}
catch (HTTPError e) {}

% endif

