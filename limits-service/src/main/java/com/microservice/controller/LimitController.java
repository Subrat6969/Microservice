package com.microservice.controller;

import org.apache.http.protocol.HTTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.model.LimitModel;
import com.microservice.util.LimitConfig;

@RestController
public class LimitController {
	
	@Autowired
	private LimitModel limitModel;
	
	@Autowired
	private LimitConfig limitConfig;
	
	@GetMapping("/limits")
	public ResponseEntity<LimitModel> getLimit(){
		limitModel.setMaximum(limitConfig.getMaximum());
		limitModel.setMinimum(limitConfig.getMinimum());
		return new ResponseEntity<LimitModel>(limitModel, HttpStatus.OK);
	}

}
