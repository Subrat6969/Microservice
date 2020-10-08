package com.microservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.entity.CurrencyExchangeEntity;
import com.microservice.service.CurrencyExchangeService;

@RestController
public class CurrencyExchangeController {
	
	@Autowired
	private CurrencyExchangeEntity entity;
	
	@Autowired
	private CurrencyExchangeService service;
	
	/*@Autowired
	private Environment env;*/
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ResponseEntity<CurrencyExchangeEntity> exchnage(@PathVariable String from,
			@PathVariable String to){
		entity=service.exchange(from, to);
		//entity.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		return new ResponseEntity<CurrencyExchangeEntity>(entity, HttpStatus.OK);
	}
	@PostMapping("/create")
	public ResponseEntity<CurrencyExchangeEntity> saveExchange(
			@RequestBody CurrencyExchangeEntity entity){
		entity=service.exchangeSave(entity);
		return new ResponseEntity<CurrencyExchangeEntity>(entity, HttpStatus.OK);
	}

}
