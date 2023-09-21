package com.intuit.craftdemo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.intuit.craftdemo.entity.UserProductMapping;

@Service
public interface ProductSubscriptionService {
	
  UserProductMapping subscribe(UserProductMapping userProductMappingObj);
		
  UserProductMapping getSubscribedProducts(String userId);
  
  List<UserProductMapping> findAll();

}
