package com.intuit.craftdemo.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
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
    
    public List<UserProductMapping> findAll(){
        return dynamoDBMapper.scan(UserProductMapping.class, new DynamoDBScanExpression());
    }

}
