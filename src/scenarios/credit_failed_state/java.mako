% if mode == 'definition':
BankAccount.credit(amount)

% else:
BankAccount ba = new BankAccount();
ba.account_number = "9900000004";
ba.name = "Johann Bernoulli";
ba.routing_number = "";
ba.type = "checking";
ba.save();
ba.credit(10000);

% endif

