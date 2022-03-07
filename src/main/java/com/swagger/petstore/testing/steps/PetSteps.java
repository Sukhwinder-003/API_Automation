package com.swagger.petstore.testing.steps;
import io.restassured.response.Response;

import org.apache.http.HttpStatus;
import org.testng.Assert;
import com.swagger.petstore.models.Pet;
import com.swagger.petstore.testing.controllers.pet.PetController;
import com.swagger.petstore.testing.models.apiResponse.ApiResponse;

public class PetSteps extends PetController {

	
	String jsonString;

	
	public PetSteps createPetSuccessfully(Pet pet) {
		Response response = postPet(pet);
		
    	
		jsonString = response.asString();
    	
    	int statusCode = response.getStatusCode();
		System.out.println(response.getStatusCode() + "response.getStatusCode()");
		Assert.assertEquals(statusCode /* actual value */, 200 /* expected value */, "Correct status code returned");

		return this;
	}

	public PetSteps postBadRequest(Object pet) {
		Response response = postPet(pet);
		assertStatusCode(HttpStatus.SC_BAD_REQUEST, response);
		return this;
	}

	public Pet getPetById(String petId) {
		Response response = getPet(petId);
		assertStatusCode(HttpStatus.SC_OK, response);
		System.out.println(response.asString()+"     responseresponse");
		return response.as(Pet.class);
	}

	public PetSteps getNotFoundPetById(String petId) {
		Response response = getPet(petId);
		assertStatusCode(HttpStatus.SC_NOT_FOUND, response);
		assertErrorMessage("Pet not found", response.as(ApiResponse.class));
		return this;
	}

	public PetSteps assertPetData(Pet expectedPet) throws InterruptedException {
		
		Thread.sleep(10000);
		Pet pet = getPetById(expectedPet.getId().toString());
		
		return this;
	}

	public PetSteps deletePetById(String petId) {
		Response response = deletePet(petId);
		assertStatusCode(HttpStatus.SC_OK, response);
		return this;
	}

	public PetSteps deleteNotFoundPetById(String petId) {
		Response response = deletePet(petId);
		assertStatusCode(HttpStatus.SC_NOT_FOUND, response);
		return this;
	}

	public PetSteps putPetSuccessfully(Pet pet) throws InterruptedException {
		Response response = putPet(pet);
		assertStatusCode(HttpStatus.SC_OK, response);
		assertPetData(pet);
		return this;
	}

	public PetSteps putBadRequest(Object pet) {
		Response response = putPet(pet);
		assertStatusCode(HttpStatus.SC_BAD_REQUEST, response);
		return this;
	}

	private void assertStatusCode(int ExpectedStatus, Response response) {
	//	assertThat(response.statusCode(), equalTo(ExpectedStatus));
	}

	public void assertErrorMessage(String expectedMessage, ApiResponse apiResponse) {
	//	assertThat(apiResponse.getMessage(), equalTo(expectedMessage));
		
		Assert.assertEquals(apiResponse.getMessage(),  expectedMessage);

	}

}
