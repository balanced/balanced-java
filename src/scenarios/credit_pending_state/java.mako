% if mode == 'definition':
BankAccount.credit(int amount);

% else:
Settings.configure("c07a8282f49111e2a035026ba7d31e6f");

BankAccount ba = new BankAccount();
ba.account_number = "9900000000";
ba.name = "Johann Bernoulli";
ba.routing_number = "121000358";
ba.type = "checking";
ba.save();
ba.credit(10000);

% endif

