package com.microservice.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.entity.CurrencyExchangeEntity;
import com.microservice.repository.CurrencyExchangeRepository;

@Service
public class CurrencyExchangeService {

	@Autowired
	private CurrencyExchangeRepository repository;

	public CurrencyExchangeEntity exchangeSave(CurrencyExchangeEntity entity) {

		if (entity.getFrom().equalsIgnoreCase("USA") && entity.getTo().equalsIgnoreCase("INR")) {
			entity.setMarketPrice(BigDecimal.valueOf(75));
		} else if (entity.getFrom().equalsIgnoreCase("EUR") && entity.getTo().equalsIgnoreCase("INR")) {
			entity.setMarketPrice(BigDecimal.valueOf(80));
		}
		repository.save(entity);

		return entity;

	}

	public CurrencyExchangeEntity exchange(String from, String to) {
		CurrencyExchangeEntity entity = repository.findbyFromAndTo(from, to);

		return entity;
	}

}
