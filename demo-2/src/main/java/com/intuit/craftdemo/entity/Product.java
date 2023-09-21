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
@DynamoDBTable(tableName="Product")
public class Product {
	
	@DynamoDBHashKey(attributeName = "productId")
	private String productId;
	
	@DynamoDBAttribute(attributeName = "productType")
	private String productType ;

}
