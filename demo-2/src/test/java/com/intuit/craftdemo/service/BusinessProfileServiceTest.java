package com.intuit.craftdemo.service;

import static org.mockito.ArgumentMatchers.any;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.intuit.craftdemo.entity.BusinessProfile;
import com.intuit.craftdemo.repo.BusinessProfileRepository;

@ExtendWith(MockitoExtension.class)
public class BusinessProfileServiceTest {
	
	@Mock
	private BusinessProfileService businessProfileService;
	
	@Mock
	private BusinessProfileRepository businessProfileRepository;
	
	@Test void testAddBusinessProfile()
    {	
		BusinessProfile businessProfile = new BusinessProfile();
		businessProfile.setCompanyName("testCompany");
		businessProfile.setLegalName("testCompany");
		businessProfile.setBusinessAddress("abcd");
		businessProfileService.addBusinessProfile("usr", businessProfile);
        Mockito.verify(businessProfileRepository, Mockito.times(1)).save(any());
    }

}
