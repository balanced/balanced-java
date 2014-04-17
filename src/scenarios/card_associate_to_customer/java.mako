% if mode == 'definition':
Card().associateToCustomer(Customer customer)

% else:
Balanced.configure("ak-test-2fYjkv4Tz5l3iPCtOlgLolmF15XPXlRCr");

Customer customer = new Customer("");
Card card = new Card("/cards/CCHv1QwjLfCxskorXDf8bmm");

try {
    card.associateToCustomer(customer);
}
catch (HTTPError e) {}

% endif

