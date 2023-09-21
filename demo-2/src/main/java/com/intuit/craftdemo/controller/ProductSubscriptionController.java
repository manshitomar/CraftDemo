package com.intuit.craftdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.intuit.craftdemo.entity.UserProductMapping;
import com.intuit.craftdemo.service.ProductSubscriptionService;

@RestController
public class ProductSubscriptionController {
	
	@Autowired
	ProductSubscriptionService productSubscriptionService;
	
	@PostMapping("/subscribe")
	public ResponseEntity<UserProductMapping> addProducts(@RequestBody UserProductMapping userProductMappingObj){
		return ResponseEntity.ok(productSubscriptionService.subscribe(userProductMappingObj));
	}

}
