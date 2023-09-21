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
	
	public BusinessProfile addBusinessProfile(String userId, BusinessProfile profile) {
		if(validateBusinessProfileData(userId, profile))
		return businessProfileRepository.save(profile);	
		else return new BusinessProfile();
	}
	
	public BusinessProfile updateBusinessProfile(String userId, String companyName, BusinessProfile profile) {
		if(validateBusinessProfileData(userId, profile)) {
			return businessProfileRepository.update(companyName, profile);	
		}
			
		else return new BusinessProfile();
	}
	
	public List<BusinessProfile> findAll() {
		return businessProfileRepository.findAll();
	}
	
	public BusinessProfile getBusinessProfileByCompanyName(String companyName) {
		return businessProfileRepository.getBusinessProfileByCompanyName(companyName);
	}
	
	public String deleteBusinessProfileByCompanyName(String companyName) {
		return businessProfileRepository.delete(companyName);
	}
	
	private boolean validateBusinessProfileData(String userId, BusinessProfile profile) {
		UserProductMapping userProductMapping = productSubscriptionService.getSubscribedProducts(userId);
		Boolean[] validate = { Boolean.TRUE };
		List<String> productTypes = Arrays.asList(userProductMapping.getProductTypes().split("\\s*,\\s*"));

		productTypes.forEach((e) -> 
			 validate[0] = validate[0] && ProductValidationFactory.getProductValidation(ProductType.valueOf(e)).validate(profile));
		
		return validate[0];
	}
	

}
