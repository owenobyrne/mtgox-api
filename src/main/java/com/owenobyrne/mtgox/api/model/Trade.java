package com.owenobyrne.mtgox.api.model;

public class Trade {
	String trade_id;
	String primary;
	String currency;
	String type;
	String properties;
	String item;
	String date;
	Currency amount;
	Currency price;
	Currency spent;
	public String getTrade_id() {
		return trade_id;
	}
	public void setTrade_id(String trade_id) {
		this.trade_id = trade_id;
	}
	public String getPrimary() {
		return primary;
	}
	public void setPrimary(String primary) {
		this.primary = primary;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getProperties() {
		return properties;
	}
	public void setProperties(String properties) {
		this.properties = properties;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Currency getAmount() {
		return amount;
	}
	public void setAmount(Currency amount) {
		this.amount = amount;
	}
	public Currency getPrice() {
		return price;
	}
	public void setPrice(Currency price) {
		this.price = price;
	}
	public Currency getSpent() {
		return spent;
	}
	public void setSpent(Currency spent) {
		this.spent = spent;
	}
	
	
}
