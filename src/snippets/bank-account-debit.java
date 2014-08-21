// bankAccountHref is the stored href for the BankAccount
// orderHref is the stored href for the Order
BankAccount bankAccount = new BankAccount(bankAccountHref);

HashMap<String, Object> payload = new HashMap<String, Object>();
payload.put("amount", 5000);
payload.put("description", "Some descriptive text for the debit in the dashboard");
payload.put("appears_on_statement_as", "Statement text");
payload.put("order", orderHref);

try {
    Debit debit = bankAccount.debit(payload);
}
catch (HTTPError e) {}