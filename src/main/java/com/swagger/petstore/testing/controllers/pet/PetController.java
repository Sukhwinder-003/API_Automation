
package com.swagger.petstore.testing.controllers.pet;


import static io.restassured.RestAssured.given;

import com.pet.swagger.utils.ConfigFileReader;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PetController {
	ConfigFileReader config = new ConfigFileReader();
	
    private final RequestSpecification requestSpecification =
    		
    		new RequestSpecBuilder()
        .log(LogDetail.ALL)
        .setContentType(ContentType.JSON)
        //.addFilter(new AllureRestAssured())
        .addHeader("api_key", "12345")
     .setBaseUri(config.getUrl())
     .setBasePath(config.getPath())
        .build();


    public Response getPet(String petId) {
        return given(requestSpecification)
            .when()
            .get(petId);
    }

    public Response postPet(Object pet) {
    	
    	
        return given(requestSpecification)
            .when()
            .body(pet)
            .post();
    }

    public Response putPet(Object pet) {
        return given(requestSpecification)
            .when()
            .body(pet)
            .put();
    }

    public Response deletePet(String petId) {
        return given(requestSpecification)
            .when()
            .delete(petId);
    }
}
