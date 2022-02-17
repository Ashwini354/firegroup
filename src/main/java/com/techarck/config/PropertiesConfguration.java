package com.techarck.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesConfguration {

	public static Properties loadProperties() {
		try {
			FileInputStream input = new FileInputStream("/Users/ashwiniramamurthy/eclipse-workspace/FireGroup/src/main/resources/Application.properties");
		

			Properties prop = new Properties();

			// load a properties file
			prop.load(input);

			return prop;
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return null;
	}

}
