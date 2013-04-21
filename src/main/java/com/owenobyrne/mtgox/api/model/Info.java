package com.owenobyrne.mtgox.api.model;

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
public class Info {
	String result;
	InfoDatum data;
	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public InfoDatum getData() {
		return data;
	}
	public void setData(InfoDatum data) {
		this.data = data;
	}
	
}
