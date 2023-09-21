package com.intuit.craftdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.intuit.craftdemo.entity.UserProductMapping;
import com.intuit.craftdemo.service.ProductSubscriptionService;

@RestController
public class ProductSubscriptionController {
	
	@Autowired
	ProductSubscriptionService productSubscriptionService;
	
	@PostMapping("/productSubscriptionService/subscribe")
	public ResponseEntity<UserProductMapping> addProducts(@RequestBody UserProductMapping userProductMappingObj){
		return ResponseEntity.ok(productSubscriptionService.subscribe(userProductMappingObj));
	}
	
	@GetMapping("/productSubscriptionService/findByUsername/{username}")
    public ResponseEntity<UserProductMapping>  findByUsername(@PathVariable(value = "username") String username){
        return ResponseEntity.ok(productSubscriptionService.getSubscribedProducts(username));
    }

    @GetMapping("/productSubscriptionService/findAll")
    public ResponseEntity<List<UserProductMapping>> findAll(){
        return ResponseEntity.ok(productSubscriptionService.findAll());
    }

}
