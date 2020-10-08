package com.microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.microservice.entity.CurrencyExchangeEntity;

@Repository
public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchangeEntity, Integer> {
	@Query("select c from CurrencyExchangeEntity c where c.from= ?1 And c.to= ?2 ")
	CurrencyExchangeEntity findbyFromAndTo(String from, String to);

}
