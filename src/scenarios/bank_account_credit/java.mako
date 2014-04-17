% if mode == 'definition':
BankAccount().credit(Map<String, Object> payload)

% else:
Balanced.configure("ak-test-2fYjkv4Tz5l3iPCtOlgLolmF15XPXlRCr");

BankAccount bankAccount = new BankAccount("/bank_accounts/BAd2UKqX83C1p7fhmMx5pmW");

HashMap<String, Object> payload = new HashMap<String, Object>();
payload.put("amount", 5000);

try {
    Credit credit = bankAccount.credit(payload);
}
catch (HTTPError e) {}

% endif

