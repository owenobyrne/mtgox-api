package com.owenobyrne.mtgox.api.model;

public class Ticker {
	String result;
	TickerDatum data;
	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public TickerDatum getData() {
		return data;
	}
	public void setData(TickerDatum data) {
		this.data = data;
	}
	
	
}
