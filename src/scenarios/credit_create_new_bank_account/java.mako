% if mode == 'definition':
BankAccount.credit(amount);

% else:
Settings.configure("2776ea40d92e11e29fe1026ba7cac9da");

BankAccount ba = new BankAccount();
ba.account_number = "9900000001";
ba.name = "Johann Bernoulli";
ba.routing_number = "121000358";
ba.type = "checking";
ba.save();
ba.credit(10000);

% endif

