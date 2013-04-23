package com.owenobyrne.mtgox.api.model;

import java.util.ArrayList;

public class TradeResultDatum {
	String order_id;
	ArrayList<Trade> trades;
	Currency total_amount;
	Currency total_spent;
	Currency avg_cost;
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public ArrayList<Trade> getTrades() {
		return trades;
	}
	public void setTrades(ArrayList<Trade> trades) {
		this.trades = trades;
	}
	public Currency getTotal_amount() {
		return total_amount;
	}
	public void setTotal_amount(Currency total_amount) {
		this.total_amount = total_amount;
	}
	public Currency getTotal_spent() {
		return total_spent;
	}
	public void setTotal_spent(Currency total_spent) {
		this.total_spent = total_spent;
	}
	public Currency getAvg_cost() {
		return avg_cost;
	}
	public void setAvg_cost(Currency avg_cost) {
		this.avg_cost = avg_cost;
	}
	
	
}
