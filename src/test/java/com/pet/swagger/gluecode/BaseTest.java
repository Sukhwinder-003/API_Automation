package com.pet.swagger.gluecode;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeTest;

import com.pet.swagger.utils.ConfigFileReader;



public class BaseTest {
	 static RequestSpecBuilder builder ;
	 static RequestSpecification requestSpecification;
	
	
	
	 @BeforeTest
	
	public static void setUp() {
		
System.out.println("Inside Before Suite");
ConfigFileReader  config=new ConfigFileReader();
RestAssured.basePath=config.getURL();
RestAssured.basePath=config.getPath();

	}

	@AfterTest

	public static void tearDown() {
		
		
		System.out.println("In @AfterClass Method");
		
		
}
}