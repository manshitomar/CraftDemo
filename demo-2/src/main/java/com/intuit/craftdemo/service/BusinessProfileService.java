package com.intuit.craftdemo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intuit.craftdemo.factory.ProductValidationFactory;
import com.intuit.craftdemo.service.ProductSubscriptionService;
import com.intuit.craftdemo.entity.UserProductMapping;
import com.intuit.craftdemo.enums.ProductType;
import com.intuit.craftdemo.entity.BusinessProfile;
import com.intuit.craftdemo.repo.BusinessProfileRepository;

@Service
public class BusinessProfileService {

	@Autowired
    private ProductValidationFactory productValidationFactory;
	
	@Autowired
	private ProductSubscriptionService productSubscriptionService;
	
	@Autowired
	BusinessProfileRepository businessProfileRepository;
	
	public BusinessProfile addBusinessProfile(BusinessProfile profile) {
		return businessProfileRepository.save(profile);	
	}
	
	public BusinessProfile updateBusinessProfile(BusinessProfile profile, String userId) {
		UserProductMapping userProductMapping = productSubscriptionService.getSubscribedProducts(userId);
		Boolean[] validate = { Boolean.TRUE };
		List<String> productTypes = Arrays.asList(userProductMapping.getProductTypes().split("\\s*,\\s*"));

		productTypes.forEach((e) -> 
			 validate[0] = validate[0] && productValidationFactory.getProductValidation(ProductType.valueOf(e)).validate(profile));
		if(validate[0])
				return businessProfileRepository.save(profile);	
		else return new BusinessProfile();
	}
	
	public BusinessProfile readBusinessProfile(String companyName) {
		return businessProfileRepository.getBusinessProfileByCompanyName(companyName);
	}
	

}
