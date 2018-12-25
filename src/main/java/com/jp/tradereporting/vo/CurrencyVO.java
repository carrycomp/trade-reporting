package com.jp.tradereporting.vo;

import java.io.Serializable;

public class CurrencyVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String currencyCode;
	private String currencyName;

	public CurrencyVO(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public CurrencyVO(String currencyCode, String currencyName) {
		this.currencyCode = currencyCode;
		this.currencyName = currencyName;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public String getCurrencyName() {
		return currencyName;
	}

	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}

	@Override
	public String toString() {
		return "currencyCode: " + currencyCode + " currencyName: " + currencyName;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null)
			return false;
		if (this.getClass() != o.getClass())
			return false;
		CurrencyVO currency = (CurrencyVO) o;
		return (currencyCode.equals(currency.getCurrencyCode()));
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 31 * hash + (currencyCode == null ? 0 : currencyCode.hashCode());
		hash = 31 * hash + (currencyName == null ? 0 : currencyName.hashCode());
		return hash;
	}
}
