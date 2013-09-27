% if mode == 'definition':
BankAccount.credit(int amount);

% else:
Balanced.configure("71d76c1223ad11e38848026ba7c1aba6");

BankAccount ba = new BankAccount();
ba.account_number = "";
ba.name = "";
ba.routing_number = "";
ba.type = "";
ba.save();
ba.credit();

% endif

