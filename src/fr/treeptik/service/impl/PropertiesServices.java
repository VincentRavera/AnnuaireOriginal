package fr.treeptik.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesServices {
	
	public String getProperties() throws IOException{
		Properties prop = new Properties();
		String fileName = "config.propeties";
		String result = "";
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName);
		
		prop.load(inputStream);
		
		result = prop.getProperty("support");
		
		return result;
		
		
		
	}
	
	

}
