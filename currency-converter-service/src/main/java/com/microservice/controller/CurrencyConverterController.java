package com.microservice.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.model.CurrencyConverterModel;
import com.microservice.service.CurrencyConverterService;

@RestController
public class CurrencyConverterController {
	
	@Autowired
	private CurrencyConverterService service;
	
	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public ResponseEntity<CurrencyConverterModel> getConvertedValue(@PathVariable String from, 
			@PathVariable String to, @PathVariable BigDecimal quantity) {
		CurrencyConverterModel model=service.getQuantityByProxy(from, to, quantity);
			//	service.getQuantity(from, to, quantity);
		//service.getQuantityByProxy(from, to, quantity);
		return new ResponseEntity<CurrencyConverterModel>(model, HttpStatus.OK);
	}

}
