package com.intuit.craftdemo.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.intuit.craftdemo.entity.UserProductMapping;
import com.intuit.craftdemo.repo.UserProductMappingRepository;

@ExtendWith(MockitoExtension.class)
public class ProductSubscriptionServiceTest {
	
	@Mock private UserProductMappingRepository userProductMappingRepository;
	 
	@Mock
    private ProductSubscriptionService productSubscriptionService;
 	
	@Test void testSubscribe()
    {	
		UserProductMapping productMapping = new UserProductMapping();
		productMapping.setUsername("testuser");
		productMapping.setProductTypes("ACCOUNTING");
		productSubscriptionService.subscribe(productMapping);
        Mockito.verify(userProductMappingRepository, Mockito.times(1)).save(any());
    }

}
