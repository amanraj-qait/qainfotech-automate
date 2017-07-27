package com.connections;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyFileReader {

	String path = "src/test/resources/Property-files/config.properties";
	static String value = "";
	static Properties properties = new Properties();
	InputStream locatorInput;

	public PropertyFileReader() {
		locatorInput = getClass().getClassLoader().getResourceAsStream("./files/config.properties");
		try {
			properties.load(locatorInput);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Read value from config.properties file
	 * 
	 * @param property
	 * @return
	 */
	public String read_property(String property) {
		value = properties.getProperty(property);
		return value;

	}

	public static void main(String[] k) {
		PropertyFileReader n = new PropertyFileReader();
		n.read_property("driver");

	}
}
