package com.intuit.craftdemo.entity;

import java.util.List;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamoDBTable(tableName="UserProductMapping")
public class UserProductMapping {
	
	@DynamoDBHashKey(attributeName = "username")
	private String username;
	
	@DynamoDBAttribute(attributeName = "productTypes")
	private String productTypes;
	
	
	public void setUsername(String username) {
		this.username = username;		
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public void setProductTypes(String productTypes) {
		this.productTypes = productTypes;		
	}
	
	public String getProductTypes() {
		return this.productTypes;
	}

}
