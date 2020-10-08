package com.microservice.model;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

@Component
public class CurrencyConverterModel {

	private int id;
	private String from;
	private String to;
	private BigDecimal marketPrice;
	private BigDecimal quantity;
	private BigDecimal total;
	//private int port;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public BigDecimal getMarketPrice() {
		return marketPrice;
	}
	public void setMarketPrice(BigDecimal marketPrice) {
		this.marketPrice = marketPrice;
	}
	public BigDecimal getQuantity() {
		return quantity;
	}
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	/*public int getPort() {
		return port;
	}*/
	/*public void setPort(int port) {
		this.port = port;
	}*/
	
	
}
