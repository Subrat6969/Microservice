package com.microservice.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservice.model.CurrencyConverterModel;
import com.microservice.restTemplateProxy.CurrencyExchangeProxy;

@Service
public class CurrencyConverterService {
	
	@Autowired
	private CurrencyExchangeProxy proxy;

	//use traditional way to get response
	public CurrencyConverterModel getQuantity(String from, String to, BigDecimal quantity) {
		
		Map<String , String > uriVaribales=new HashMap<>();
		try {
			uriVaribales.put("from", from);
			uriVaribales.put("to", to);
			ResponseEntity<CurrencyConverterModel> responseEntity= 
					new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}",
					CurrencyConverterModel.class,uriVaribales); 
			//variable name should be same with url entity name 
			CurrencyConverterModel modelClass=responseEntity.getBody();
			modelClass.setQuantity(quantity);
			
			modelClass.setTotal(modelClass.getMarketPrice().multiply(modelClass.getQuantity()));
			return modelClass;
		}
		catch(Exception e) {
			System.out.println("responseEntity exception"+e.getMessage());
		}
		return null;
	}
	public CurrencyConverterModel getQuantityByProxy(String from, String to, BigDecimal quantity) {
		
		try {
			CurrencyConverterModel model= proxy.exchnage(from, to);
			model.setQuantity(quantity);
			model.setTotal(model.getMarketPrice().multiply(model.getQuantity()));
			return model;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
		
	}
}
