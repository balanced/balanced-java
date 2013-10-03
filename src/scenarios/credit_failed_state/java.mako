% if mode == 'definition':
BankAccount.credit(int amount);

% else:
Balanced.configure("ak-test-2ppXve1BnInnsIKZytspDrsuhjtAT9dD8");

BankAccount ba = new BankAccount();
ba.account_number = "";
ba.name = "";
ba.routing_number = "";
ba.type = "";
ba.save();
ba.credit();

% endif

