% if mode == 'definition':
Card().associateToCustomer(Customer customer)

% else:
Balanced.configure("ak-test-25ZY8HQwZPuQtDecrxb671LilUya5t5G0");

Customer customer = new Customer("");
Card card = new Card("/cards/CC3IBNr3erYpVuuZDyWNFfet");

try {
    card.associateToCustomer(customer);
}
catch (HTTPError e) {}

% endif

