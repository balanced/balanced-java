% if mode == 'definition':
Account.credits;

% else:
Settings.configure("71d76c1223ad11e38848026ba7c1aba6");

Account account = new Account("/v1/bank_accounts/BA43YHYoNLyuUUJ0VjZpKBpd");
Credit.Collection credits = account.credits;

% endif

