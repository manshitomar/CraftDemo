package com.intuit.craftdemo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import com.intuit.craftdemo.entity.UserProductMapping;
import com.intuit.craftdemo.repo.UserProductMappingRepository;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class ProductSubscriptionServiceTest {
	
	@Mock private UserProductMappingRepository userProductMappingRepository;
	 
	@InjectMocks
    private ProductSubscriptionServiceImpl productSubscriptionService;
	
	@BeforeEach
	public void init() {
		
		UserProductMapping productMapping = new UserProductMapping();
		productMapping.setUsername("testuser");
		productMapping.setProductTypes("ACCOUNTING");
		List<UserProductMapping> myList = new ArrayList<>();
		myList.add(productMapping);
		when(userProductMappingRepository.save(any())).thenReturn(productMapping);
		when(userProductMappingRepository.findAll()).thenReturn(myList);
		when(userProductMappingRepository.getUserProductMappingByUsername(any())).thenReturn(productMapping);
	}
		
 	
	@Test void testSubscribe()
    {	
		UserProductMapping productMapping = new UserProductMapping();
		productMapping.setUsername("testuser");
		productMapping.setProductTypes("ACCOUNTING");
		UserProductMapping productMappingObj = productSubscriptionService.subscribe(productMapping);
		assertNotNull(productMappingObj);
		assertEquals(productMappingObj.getProductTypes(), productMapping.getProductTypes());

    }
	
	@Test void testFindAll()
    {	

		List<UserProductMapping> productMappingList = productSubscriptionService.findAll();
		assertNotNull(productMappingList);
		assertEquals(productMappingList.size(), 1);
		
    }
	
	@Test void testGetSubscribedProducts()
    {	
		UserProductMapping productMappingObj = productSubscriptionService.getSubscribedProducts("testuser");
		assertNotNull(productMappingObj);
		assertEquals(productMappingObj.getProductTypes(), "ACCOUNTING");
		assertEquals(productMappingObj.getUsername(), "testuser");

    }

}
