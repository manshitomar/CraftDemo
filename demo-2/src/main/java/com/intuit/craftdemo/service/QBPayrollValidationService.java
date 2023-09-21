package com.intuit.craftdemo.service;

import org.springframework.stereotype.Service;

import com.intuit.craftdemo.entity.BusinessProfile;
import com.intuit.craftdemo.enums.ProductType;

@Service
public class QBPayrollValidationService implements ProductValidationService {
	
	@Override
	public ProductType getType() {
		return ProductType.PAYROLL;
	}

	@Override
	public Boolean validate(BusinessProfile businessProfile) {
		return Boolean.TRUE;
	}
}
