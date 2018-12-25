package com.jp.tradereporting.constants;

import com.jp.tradereporting.exception.ApplicationException;

public enum TransactionType {
	B("BUY"), S("SELL");
	private String code;

	TransactionType(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "SIDE: " + code;
	}

	public TransactionType getByCode(String code) throws ApplicationException {
		for (TransactionType side : values()) {
			if (side.code.equalsIgnoreCase(code)) {
				return side;
			}
		}
		throw new ApplicationException("Couldnt find side %s", code);

	}
}
