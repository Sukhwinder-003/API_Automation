package com.pet.swagger.gluecode;

import org.testng.annotations.Test;

import com.swagger.petstore.api.utils.CreateTestData;

import com.swagger.petstore.models.Pet;
import com.swagger.petstore.testing.steps.PetSteps;

public class GetPetRequest {

	private final PetSteps petSteps = new PetSteps();
	private final Pet fullDataPet = CreateTestData.generateFullDataPet();
	private final String notFoundId = "-1";

	@Test(priority = 4)

	public void getPetTest() throws InterruptedException {
		petSteps.createPetSuccessfully(fullDataPet).assertPetData(fullDataPet);
	}

	@Test(priority = 5)
	public void getNotFoundPetTest() {

		petSteps.getNotFoundPetById(notFoundId);
	}

}
