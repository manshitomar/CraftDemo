package com.intuit.craftdemo.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.intuit.craftdemo.entity.BusinessProfile;


@Repository
public class BusinessProfileRepository{
	
	@Autowired
    private DynamoDBMapper dynamoDBMapper;


    public BusinessProfile save(BusinessProfile businessProfile) {
        dynamoDBMapper.save(businessProfile);
        return businessProfile;
    }

    public BusinessProfile getBusinessProfileByCompanyName(String companyName) {
        return dynamoDBMapper.load(BusinessProfile.class, companyName);
    }
    
    public void deleteBusinessProfileByCompanyName(BusinessProfile businessProfile) {
         dynamoDBMapper.delete(businessProfile);
    }

}

