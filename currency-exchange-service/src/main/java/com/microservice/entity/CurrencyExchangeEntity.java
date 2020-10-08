package com.microservice.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;


@Entity
@Table(name= "Currency_Exchange")
@Component
public class CurrencyExchangeEntity {
	
	@Id
	private long id;
	
	@Column(name ="Currency_From")
	private String from;
	
	@Column(name="Currency_to")
	private String to;
	
	@Column(name="Multiply_Value")
	private BigDecimal marketPrice;
	
	//private int port;

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	/*public int getPort() {
		return port;
	}*/

	/*public void setPort(int port) {
		this.port = port;
	}*/
	

}
