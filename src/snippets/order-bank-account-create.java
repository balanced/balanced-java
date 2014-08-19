Map<String, Object> bankAccountPayload = new HashMap<String, Object>();
bankAccountPayload.put("account_number", "0987654321");
bankAccountPayload.put("name", "Johann Bernoulli");
bankAccountPayload.put("routing_number", "321174851");
bankAccountPayload.put("account_type", "checking");

BankAccount bankAccount = new BankAccount(bankAccountPayload);
try {
    bankAccount.save();
    bankAccount.associateToCustomer(merchant);
}
catch (HTTPError e) {}