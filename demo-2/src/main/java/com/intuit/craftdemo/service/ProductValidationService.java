package com.intuit.craftdemo.service;

import org.springframework.stereotype.Service;

import com.intuit.craftdemo.entity.BusinessProfile;
import com.intuit.craftdemo.enums.ProductType;

@Service
public interface ProductValidationService {
	ProductType getType();
	Boolean validate(BusinessProfile businessProfile);

}
