package com.intuit.craftdemo.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamoDBTable(tableName="User")
public class User {
	
	@DynamoDBHashKey(attributeName = "username")
	private String username;
	
	@DynamoDBAttribute
	private String password;
	
	@DynamoDBAttribute
	private String email;

}
