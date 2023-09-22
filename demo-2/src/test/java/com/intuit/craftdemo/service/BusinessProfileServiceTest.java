package com.intuit.craftdemo.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.intuit.craftdemo.entity.BusinessProfile;
import com.intuit.craftdemo.entity.UserProductMapping;
import com.intuit.craftdemo.enums.ProductType;
import com.intuit.craftdemo.factory.ProductValidationFactory;
import com.intuit.craftdemo.repo.BusinessProfileRepository;

@ExtendWith(MockitoExtension.class)
public class BusinessProfileServiceTest {
	
	@InjectMocks
	private BusinessProfileService businessProfileService;
	
	@Mock
	private ProductValidationFactory productValidationFactory;
	
	@Mock
	private BusinessProfileRepository businessProfileRepository;
	
	@Mock
	private ProductSubscriptionService productSubscriptionService;
	
	
	@Test void testGetBusinessProfileByCompanyName()
    {	
		BusinessProfile businessProfile = new BusinessProfile();
		businessProfile.setCompanyName("testCompany");
		businessProfile.setLegalName("testCompany");
		businessProfile.setBusinessAddress("abcd");
		when(businessProfileService.getBusinessProfileByCompanyName(any())).thenReturn(businessProfile);
		BusinessProfile businessProfileObj = businessProfileService.getBusinessProfileByCompanyName("testCompany");
		assertNotNull(businessProfileObj);
		assertEquals(businessProfileObj.getBusinessAddress(), businessProfile.getBusinessAddress());
    }
	
	@Test void testDeleteBusinessProfileByCompanyName()
    {	
		when(businessProfileService.deleteBusinessProfileByCompanyName(any())).thenReturn("Success");
		String response = businessProfileService.deleteBusinessProfileByCompanyName("usr");
		assertNotNull(response);
    }
	
	@Test void testFindAll()
    {	
		BusinessProfile businessProfile = new BusinessProfile();
		businessProfile.setCompanyName("testCompany");
		businessProfile.setLegalName("testCompany");
		businessProfile.setBusinessAddress("abcd");
		List<BusinessProfile> myList = new ArrayList<>();
		myList.add(businessProfile);
		when(businessProfileService.findAll()).thenReturn(myList);
		List<BusinessProfile> buList = businessProfileService.findAll();
		assertNotNull(buList);
		assertEquals(buList.size(), 1);
    }

}
