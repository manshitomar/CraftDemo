package com.intuit.craftdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intuit.craftdemo.entity.UserProductMapping;
import com.intuit.craftdemo.repo.UserProductMappingRepository;

	@Service
public class ProductSubscriptionServiceImpl implements ProductSubscriptionService {
	
	@Autowired
	UserProductMappingRepository userProductMappingRepository;
	
	@Override
	public UserProductMapping subscribe(UserProductMapping userProductMappingObj) {
		return userProductMappingRepository.save(userProductMappingObj);

	}
	
	@Override
	public UserProductMapping getSubscribedProducts(String username) {
		return userProductMappingRepository.getUserProductMappingByUsername(username);
	}

}
