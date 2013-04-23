package com.owenobyrne.mtgox.api.model;


public class TradeResult {
	String result;
	TradeResultDatum data;
	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public TradeResultDatum getData() {
		return data;
	}
	public void setData(TradeResultDatum data) {
		this.data = data;
	}
	
}
