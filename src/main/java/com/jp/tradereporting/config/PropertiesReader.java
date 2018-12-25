package com.jp.tradereporting.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;

import com.jp.tradereporting.logger.Logger;

public class PropertiesReader {

	private final Properties configProp = new Properties();

	private static final PropertiesReader propertiesReader = new PropertiesReader();

	private PropertiesReader() {
		InputStream in = this.getClass().getClassLoader().getResourceAsStream("app.properties");
		Logger.logMessage(this.getClass().getName(),"Read all properties from file");
		try {
			configProp.load(in);
		} catch (IOException e) {
			Logger.logException(this.getClass().getName(),"Problem while reading properties file", e);
		}
	}

	public static PropertiesReader getInstance() {
		return propertiesReader;
	}

	public String getProperty(String key) {
		return configProp.getProperty(key);
	}

	public Set<String> getAllPropertyNames() {
		return configProp.stringPropertyNames();
	}

	public boolean containsKey(String key) {
		return configProp.containsKey(key);
	}

}
