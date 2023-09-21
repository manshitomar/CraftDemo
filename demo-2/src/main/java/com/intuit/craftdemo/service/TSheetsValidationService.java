package com.intuit.craftdemo.service;

import com.intuit.craftdemo.entity.BusinessProfile;
import com.intuit.craftdemo.enums.ProductType;

public class TSheetsValidationService implements ProductValidationService{

	@Override
	public ProductType getType() {
		return ProductType.TIMETRACKER;
	}

	@Override
	public Boolean validate(BusinessProfile businessProfile) {
		return Boolean.TRUE;
	}
}
