% if mode == 'definition':
CardHold().capture(Map<String, Object> payload)

% else:
Balanced.configure("ak-test-2cSDy37BKy5K4NUHKHVNXNTjTHPEqjRtB");

CardHold cardHold = new CardHold("/card_holds/HL4a1BKhDiVV9Ueh9MTozVDs");

Map<String, Object> payload = new HashMap<String, Object>();
payload.put("amount", 1000);
payload.put("description", "Some descriptive text for the debit in the dashboard");
payload.put("appears_on_statement_as", "ShowsUpOnStmt");

cardHold.capture(payload);

% endif

