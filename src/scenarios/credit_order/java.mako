% if mode == 'definition':
Order().creditTo(BankAccount bankAccount, Map<String, Object> payload)

% else:
Balanced.configure("ak-test-aUV295IugdhWSNx2JFckYBCSvfY2ibgq");

BankAccount bankAccount = new BankAccount("/bank_accounts/BA5KLH6jhFgtVENHXOcF3Cfj/credits");
Order order = new Order("/orders/OR5QcYnwysJXQswImokq6ZSx");

HashMap<String, Object> payload = new HashMap<String, Object>();
payload.put("amount", 5000);

try {
    Credit credit = order.creditTo(bankAccount, payload);
}
catch (HTTPError e) {}

% endif

