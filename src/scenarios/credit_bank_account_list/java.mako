% if mode == 'definition':
Account.credits;

% else:
Settings.configure("c07a8282f49111e2a035026ba7d31e6f");

Account account = new Account("/v1/bank_accounts/BA6h2sjI8Q4zTtuyFDwUzbHN");
Credit.Collection credits = account.credits;

% endif

