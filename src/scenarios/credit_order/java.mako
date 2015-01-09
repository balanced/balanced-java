% if mode == 'definition':
Order().creditTo(BankAccount bankAccount, Map<String, Object> payload)

% else:
Balanced.configure("ak-test-2eKlj1ZDfAcZSARMf3NMhBHywDej0avSY");

BankAccount bankAccount = new BankAccount("/bank_accounts/BA45anEaEr8g0lOhzhcE9VAN/credits");
Order order = new Order("/orders/OR3vURGwVtqDnnkRS9fgH41G");

HashMap<String, Object> payload = new HashMap<String, Object>();
payload.put("amount", 5000);

try {
    Credit credit = order.creditTo(bankAccount, payload);
}
catch (HTTPError e) {}

% endif

