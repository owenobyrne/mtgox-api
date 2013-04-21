package com.owenobyrne.mtgox.api.model;


/**
 * 
 * "data": {
        "high":       **Currency Object - USD**,
        "low":        **Currency Object - USD**,
        "avg":        **Currency Object - USD**,
        "vwap":       **Currency Object - USD**,
        "vol":        **Currency Object - BTC**,
        "last_local": **Currency Object - USD**,
        "last_orig":  **Currency Object - ???**,
        "last_all":   **Currency Object - USD**,
        "last":       **Currency Object - USD**,
        "buy":        **Currency Object - USD**,
        "sell":       **Currency Object - USD**,
        "now":        "1364689759572564"
    }
 * 
 * @author Owen
 *
 */
public class TickerDatum {
	Currency high;
	Currency low;
	Currency avg;
	Currency vwap;
	Currency vol;
	Currency last_local;
	Currency last_orig;
	Currency last_all;
	Currency last;
	Currency buy;
	Currency sell;
	String item;
	long now;
	
	
	public Currency getHigh() {
		return high;
	}
	public void setHigh(Currency high) {
		this.high = high;
	}
	public Currency getLow() {
		return low;
	}
	public void setLow(Currency low) {
		this.low = low;
	}
	public Currency getAvg() {
		return avg;
	}
	public void setAvg(Currency avg) {
		this.avg = avg;
	}
	public Currency getVwap() {
		return vwap;
	}
	public void setVwap(Currency vwap) {
		this.vwap = vwap;
	}
	public Currency getVol() {
		return vol;
	}
	public void setVol(Currency vol) {
		this.vol = vol;
	}
	public Currency getLast_local() {
		return last_local;
	}
	public void setLast_local(Currency last_local) {
		this.last_local = last_local;
	}
	public Currency getLast_orig() {
		return last_orig;
	}
	public void setLast_orig(Currency last_orig) {
		this.last_orig = last_orig;
	}
	public Currency getLast_all() {
		return last_all;
	}
	public void setLast_all(Currency last_all) {
		this.last_all = last_all;
	}
	public Currency getLast() {
		return last;
	}
	public void setLast(Currency last) {
		this.last = last;
	}
	public Currency getBuy() {
		return buy;
	}
	public void setBuy(Currency buy) {
		this.buy = buy;
	}
	public Currency getSell() {
		return sell;
	}
	public void setSell(Currency sell) {
		this.sell = sell;
	}
	public long getNow() {
		return now;
	}
	public void setNow(long now) {
		this.now = now;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	
	
}
