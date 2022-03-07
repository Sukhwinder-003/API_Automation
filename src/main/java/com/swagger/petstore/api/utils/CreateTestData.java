package com.swagger.petstore.api.utils;

import org.apache.commons.lang3.RandomStringUtils;
import com.swagger.petstore.models.Pet;

import com.swagger.petstore.models.Category;
import com.swagger.petstore.models.Status;
import com.swagger.petstore.models.Tag;

import java.util.Arrays;
import java.util.Random;

public class CreateTestData {

	
	
	 public static Pet generateFullDataPet() {
	        return Pet.builder()
	            .id(getRandomInt())
	            .name(getRandomString())
	            .photoUrls(Arrays.asList(getRandomString(), getRandomString()))
	            .category(Category.builder().id(getRandomInt()).name(getRandomString()).build())
	            .tags(Arrays.asList(Tag.builder().id(getRandomInt()).name(getRandomString()).build(),
	                Tag.builder().id(getRandomInt()).name(getRandomString()).build()))
	            .status(Status.available)
	            .build();
	    }


		public static Pet generateMinDataPet() {
			return Pet.builder().id(getRandomInt()).name(getRandomString()).build();
		}

    private static Integer getRandomInt() {
        return new Random().nextInt((65536) - 32768);
    }

    private static String getRandomString() {
        return RandomStringUtils.randomAlphabetic(7);
    }
}
