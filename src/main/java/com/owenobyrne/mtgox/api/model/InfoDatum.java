package com.owenobyrne.mtgox.api.model;

import java.util.HashMap;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * 
 * {
    "data": {
        "Created": "yyyy-mm-dd hh:mm:ss",
        "Id": "abc123",
        "Index": "123",
        "Language": "en_US",
        "Last_Login": "yyyy-mm-dd hh:mm:ss",
        "Login": "username",
        "Monthly_Volume":                   **Currency Object**,
        "Trade_Fee": 0.6,
        "Rights": ['deposit', 'get_info', 'merchant', 'trade', 'withdraw'],
        "Wallets": {
            "BTC": {
                "Balance":                  **Currency Object**,
                "Daily_Withdraw_Limit":     **Currency Object**,
                "Max_Withdraw":             **Currency Object**,
                "Monthly_Withdraw_Limit": null,
                "Open_Orders":              **Currency Object**,
                "Operations": 1,
            },
            "USD": {
                "Balance":                  **Currency Object**,
                "Daily_Withdraw_Limit":     **Currency Object**,
                "Max_Withdraw":             **Currency Object**,
                "Monthly_Withdraw_Limit":   **Currency Object**,
                "Open_Orders":              **Currency Object**,
                "Operations": 0,
            },
            "JPY":{...}, "EUR":{...},
            // etc, depends what wallets you have
        },
    },
    "result": "success"
}

 * @author Owen
 *
 */
public class InfoDatum {
	@JsonProperty("Created")
	String Created;
	@JsonProperty("Id")
	String Id;
	@JsonProperty("Index")
	long Index;
	@JsonProperty("Language")
	String Language;
	@JsonProperty("Last_Login")
	String Last_Login;
	@JsonProperty("Login")
	String Login;
	@JsonProperty("Monthly_Volume")
	Currency Monthly_Volume;
	@JsonProperty("Trade_Fee")
	double Trade_Fee;
	@JsonProperty("Rights")
	String[] Rights;
	@JsonProperty("Wallets")
	HashMap<String, Wallet> Wallets;
    
	public String getCreated() {
		return Created;
	}
	public void setCreated(String created) {
		Created = created;
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public long getIndex() {
		return Index;
	}
	public void setIndex(long index) {
		Index = index;
	}
	public String getLanguage() {
		return Language;
	}
	public void setLanguage(String language) {
		Language = language;
	}
	public String getLast_Login() {
		return Last_Login;
	}
	public void setLast_Login(String last_Login) {
		Last_Login = last_Login;
	}
	public String getLogin() {
		return Login;
	}
	public void setLogin(String login) {
		Login = login;
	}
	public Currency getMonthly_Volume() {
		return Monthly_Volume;
	}
	public void setMonthly_Volume(Currency monthly_Volume) {
		Monthly_Volume = monthly_Volume;
	}
	public double getTrade_Fee() {
		return Trade_Fee;
	}
	public void setTrade_Fee(double trade_Fee) {
		Trade_Fee = trade_Fee;
	}
	public String[] getRights() {
		return Rights;
	}
	public void setRights(String[] rights) {
		Rights = rights;
	}
	public HashMap<String, Wallet> getWallets() {
		return Wallets;
	}
	public void setWallets(HashMap<String, Wallet> wallets) {
		Wallets = wallets;
	}
    
    
}
