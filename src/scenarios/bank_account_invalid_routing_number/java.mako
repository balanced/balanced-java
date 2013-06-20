% if mode == 'definition':

% else:
BankAccount ba = new BankAccount("/v1/marketplaces/TEST-MP1cY43VkrOlypoTc5lxfstI/bank_accounts");
ba.account_number = "9900000001";
ba.routing_number = "111111118";
ba.name = "Johann Bernoulli";
ba.type = "checking";
try {
    ba.save();
}
catch (HTTPError e) {
    // handle invalid routing numbers
}

% endif

