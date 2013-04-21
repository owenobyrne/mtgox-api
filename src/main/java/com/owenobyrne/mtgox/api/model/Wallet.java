package com.owenobyrne.mtgox.api.model;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * "BTC": {
                "Balance":                  **Currency Object**,
                "Daily_Withdraw_Limit":     **Currency Object**,
                "Max_Withdraw":             **Currency Object**,
                "Monthly_Withdraw_Limit": null,
                "Open_Orders":              **Currency Object**,
                "Operations": 1,
            },
 * 
 * @author Owen
 *
 */

public class Wallet {
	@JsonProperty("Balance")
	Currency Balance;
	@JsonProperty("Daily_Withdraw_Limit")
	Currency Daily_Withdraw_Limit;
	@JsonProperty("Max_Withdraw")
	Currency Max_Withdraw;
	@JsonProperty("Monthly_Withdraw_Limit")
	Currency Monthly_Withdraw_Limit;
	@JsonProperty("Open_Orders")
	Currency Open_Orders;
	@JsonProperty("Operations")
	int Operations;
	
	public Currency getBalance() {
		return Balance;
	}
	public void setBalance(Currency balance) {
		Balance = balance;
	}
	public Currency getDaily_Withdraw_Limit() {
		return Daily_Withdraw_Limit;
	}
	public void setDaily_Withdraw_Limit(Currency daily_Withdraw_Limit) {
		Daily_Withdraw_Limit = daily_Withdraw_Limit;
	}
	public Currency getMax_Withdraw() {
		return Max_Withdraw;
	}
	public void setMax_Withdraw(Currency max_Withdraw) {
		Max_Withdraw = max_Withdraw;
	}
	public Currency getMonthly_Withdraw_Limit() {
		return Monthly_Withdraw_Limit;
	}
	public void setMonthly_Withdraw_Limit(Currency monthly_Withdraw_Limit) {
		Monthly_Withdraw_Limit = monthly_Withdraw_Limit;
	}
	public Currency getOpen_Orders() {
		return Open_Orders;
	}
	public void setOpen_Orders(Currency open_Orders) {
		Open_Orders = open_Orders;
	}
	public int getOperations() {
		return Operations;
	}
	public void setOperations(int operations) {
		Operations = operations;
	}
	
	
}
