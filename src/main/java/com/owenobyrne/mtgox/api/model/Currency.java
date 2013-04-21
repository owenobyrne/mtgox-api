package com.owenobyrne.mtgox.api.model;

import java.math.BigDecimal;

/**
 * {
 *   "currency": "BTC",
 *   "display": "17.96800010\u00a0BTC",
 *   "display_short": "17.97\u00a0BTC",
 *   "value": "17.96800010",
 *   "value_int": "1796800010"
 * }
 * 
 * @author Owen
 *
 */
public class Currency {
	String currency;
	String display;
	String display_short;
	BigDecimal value;
	BigDecimal value_int;
	
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getDisplay() {
		return display;
	}
	public void setDisplay(String display) {
		this.display = display;
	}
	public String getDisplay_short() {
		return display_short;
	}
	public void setDisplay_short(String display_short) {
		this.display_short = display_short;
	}
	public BigDecimal getValue() {
		return value;
	}
	public void setValue(BigDecimal value) {
		this.value = value;
	}
	public BigDecimal getValue_int() {
		return value_int;
	}
	public void setValue_int(BigDecimal value_int) {
		this.value_int = value_int;
	}
	
	
}
