% if mode == 'definition':
BankAccount.getVerification();

% else:
Settings.configure("6f755804f3e111e295f6026ba7cd33d0");

BankAccount ba = new BankAccount("/v1/bank_accounts/BA3IDBjKbu6ZU2gnuJP0AQeQ");
ba.verification_uri = "/v1/bank_accounts/BA3IDBjKbu6ZU2gnuJP0AQeQ/verifications/BZ3JxvsSpQJjqUpJAyQZKqVW";
BankAccountVerification verification = ba.getVerification();

% endif

