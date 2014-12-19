Map<String, Object> settlementPayload = new HashMap<String, Object>();
settlementPayload.put("funding_instrument", bankAccount.href);
settlementPayload.put("appears_on_statement_as", "ThingsCo");

Settlement settlement = payableAccount.settle(settlementPayload);