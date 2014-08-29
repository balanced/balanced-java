Card card = new Card(cardHref);

try {
    card.associateToCustomer(customer);
}
catch (HTTPError e) {}