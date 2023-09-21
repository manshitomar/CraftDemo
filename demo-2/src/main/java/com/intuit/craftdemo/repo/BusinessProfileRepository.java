package com.intuit.craftdemo.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.intuit.craftdemo.entity.BusinessProfile;


@Repository
public class BusinessProfileRepository{
	
	@Autowired
    private DynamoDBMapper dynamoDBMapper;


    public BusinessProfile save(BusinessProfile employee) {
        dynamoDBMapper.save(employee);
        return employee;
    }

    public BusinessProfile getEmployeeById(String businessProfileId) {
        return dynamoDBMapper.load(BusinessProfile.class, businessProfileId);
    }

}

