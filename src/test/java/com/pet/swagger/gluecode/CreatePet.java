package com.pet.swagger.gluecode;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jayway.restassured.RestAssured;
import com.pet.swagger.utils.ConfigFileReader;
import com.swagger.petstore.api.utils.CreateTestData;
import com.swagger.petstore.models.Pet;
import com.swagger.petstore.testing.data.IncorrectData;
import com.swagger.petstore.testing.steps.PetSteps;


public class CreatePet {

	private final PetSteps petSteps = new PetSteps();
	private final Pet minDataPet = CreateTestData.generateMinDataPet();
	private final Pet fullDataPet = CreateTestData.generateFullDataPet();
	ConfigFileReader config = new ConfigFileReader();

	@BeforeMethod
	public void setup() {
		// Setting BaseURI once
		RestAssured.baseURI = config.getUrl() + config.getPath();
		// Setting BasePath once
		RestAssured.basePath = config.getPath();
	}

	
	  @Test(priority = 1) public void createMinDataPet() {
	  
	  petSteps.createPetSuccessfully(minDataPet);
	  
	  }
	  
	  @Test(priority = 2)
	  
	  public void createFullDataPet() {
	  petSteps.createPetSuccessfully(fullDataPet); }
	 

	@Test(priority = 3)

	public void postIncorrectJson() {
		petSteps.postBadRequest(IncorrectData.INCORRECT_JSON);
	}

}
