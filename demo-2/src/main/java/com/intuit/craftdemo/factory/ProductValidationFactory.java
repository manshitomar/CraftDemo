package com.intuit.craftdemo.factory;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.intuit.craftdemo.enums.ProductType;
import com.intuit.craftdemo.service.ProductValidationService;

@Component
public class ProductValidationFactory {
	
	private static Map<ProductType, ProductValidationService> productMap;

    @Autowired
    private ProductValidationFactory(List<ProductValidationService> productTypes) {
    	productMap =    productTypes.stream().collect(Collectors.toUnmodifiableMap(ProductValidationService::getType, Function.identity()));
    }

    public  <T> ProductValidationService getProductValidation(ProductType productType) {
        return   Optional.ofNullable(productMap.get(productType)).orElseThrow(IllegalArgumentException::new);
    }

}
