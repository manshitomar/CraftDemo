package com.intuit.craftdemo.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.intuit.craftdemo.entity.BusinessProfile;
import com.intuit.craftdemo.entity.UserProductMapping;

@Repository
public class UserProductMappingRepository {
	
	@Autowired
    private DynamoDBMapper dynamoDBMapper;
	
	public UserProductMapping save(UserProductMapping userProductMapping) {
        dynamoDBMapper.save(userProductMapping);
        return userProductMapping;
    }

    public UserProductMapping getUserProductMappingByUsername(String username) {
        return dynamoDBMapper.load(UserProductMapping.class, username);
    }

}
