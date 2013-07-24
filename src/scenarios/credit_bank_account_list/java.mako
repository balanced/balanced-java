% if mode == 'definition':
Account.credits;

% else:
Settings.configure("6f755804f3e111e295f6026ba7cd33d0");

Account account = new Account("/v1/bank_accounts/BA3Nbu8VgkUGaNdl3rm3e15I");
Credit.Collection credits = account.credits;

% endif

