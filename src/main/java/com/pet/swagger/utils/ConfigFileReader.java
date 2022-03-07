package com.pet.swagger.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
	private static Properties properties = new Properties();
	static ConfigFileReader config = new ConfigFileReader();

	String currentDirectory = System.getProperty("user.dir");
	private final String propertyFilePath = currentDirectory + "/src/test/java/utils/config.properties";

	
	
	public ConfigFileReader() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			/*
			 * properties = new Properties();
			 */ try {
				ConfigFileReader.properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}
	}

	public String getURL() {
		String url = properties.getProperty("url");
		if (url != null)
			return url;
		else
			throw new RuntimeException("url is  not specified in the Configuration.properties file.");
	}

	
	public String getPath() {
		String Path = properties.getProperty("Path");
		if (Path != null)
			return Path;
		else
			throw new RuntimeException("Path  is  not specified in the Configuration.properties file.");
	}

	public String getTestCase1BodyData() {
		String TestCase1BodyData = properties.getProperty("TestCase1BodyData");
		if (TestCase1BodyData != null)
			return TestCase1BodyData;
		else
			throw new RuntimeException("TestCase1BodyData  is  not specified in the Configuration.properties file.");
	}

	public String getUrl() {
		String getUrl = properties.getProperty("url");
		if (getUrl != null)
			return getUrl;
		else
			throw new RuntimeException("url  is  not specified in the Configuration.properties file.");
	}

	
	
	
	public String getPetID() {
		String PetID = properties.getProperty("PetID");
		if (PetID != null)
			return PetID;
		else
			throw new RuntimeException("PetID  is  not specified in the Configuration.properties file.");
	}

	
	
	
	
	
	
	
	
	public String StoreURL() {
		String StoreURL = properties.getProperty("StoreURL");
		if (StoreURL != null)
			return StoreURL;
		else
			throw new RuntimeException("StoreURL is  not specified in the Configuration.properties file.");
	}

	
	public String getCookieValue() {
		String url = properties.getProperty("cookieValue");
		if (url != null)
			return url;
		else
			throw new RuntimeException("cookieValue is  not specified in the Configuration.properties file.");
	}



}