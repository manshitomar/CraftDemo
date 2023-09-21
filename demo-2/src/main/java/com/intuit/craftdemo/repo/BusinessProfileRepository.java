package com.intuit.craftdemo.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
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
    
    public List<BusinessProfile> findAll() {
        return dynamoDBMapper.scan(BusinessProfile.class, new DynamoDBScanExpression());
    }
    
    public BusinessProfile update(String companyName, BusinessProfile profile){
        dynamoDBMapper.save(profile,
                new DynamoDBSaveExpression()
        .withExpectedEntry("companyName",
                new ExpectedAttributeValue(
                        new AttributeValue().withS(companyName)
                )));
        return profile;
    }
    
    public String delete(String companyName){
    	BusinessProfile businessProfile = dynamoDBMapper.load(BusinessProfile.class, companyName);
         dynamoDBMapper.delete(businessProfile);
         return "businessProfile deleted successfully:: "+ companyName;
     }

}

