package config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import testCases.ExecuteTest;

public class PropertiesFile {
	
	static Properties  prop = new Properties();	
	
	public static void main(String[] args) {
		
		getProperties();
			
	}

	public static void getProperties() {
		try {
		
		InputStream input = new FileInputStream(System.getProperty("user.dir")+"/src/test/java/config/config.properties");
		prop.load(input);
		
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
			
		//System.out.println(url);
		//System.out.println(username);
		//System.out.println(password);
		
		ExecuteTest.url = url;
		ExecuteTest.username = username;
		ExecuteTest.password = password;
		
			
	
		} catch (Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
		
	}
	
}





