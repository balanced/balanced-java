% if mode == 'definition':
BankAccount.credit(int amount);

% else:
Settings.configure("6f755804f3e111e295f6026ba7cd33d0");

BankAccount ba = new BankAccount();
ba.account_number = "9900000005";
ba.name = "Johann Bernoulli";
ba.routing_number = "121000358";
ba.type = "checking";
ba.save();
ba.credit(10000);

% endif

