package com.accenture.kdc.common.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.accenture.kdc.common.exception.NonBizException;

public class Configuration {
	private static Log log = LogFactory.getLog(Configuration.class);
	private static Properties props = new Properties();
	// singleton
	private static Configuration configuration;
	
	private Configuration() {
		initialize();
	}

	private void initialize() {
		ClassLoader cl;
		cl = Thread.currentThread().getContextClassLoader();
		if(cl == null) {
			cl = ClassLoader.getSystemClassLoader();
		}
		URL dbURL = cl.getResource("db-properties.properties");
		File filename = new File(dbURL.getFile());
		String configFileName = filename.getAbsolutePath();
		log.debug("filename : "+filename);
		log.debug("configFileName : "+configFileName);
		
		
		File configFile = new File(configFileName);
		if(!configFile.canRead()) {
			throw new NonBizException("Can't open configuration file : "+configFileName);
		}
		
		FileInputStream fin = null;
		try {
			fin = new FileInputStream(configFile);
			props.load(new BufferedInputStream(fin));
			log.debug("############### Properties Load start");
			String jdbcUrl = props.getProperty("jdbcUrl");
			String userId = props.getProperty("userId");
			String password = props.getProperty("password");
			String jdbcDriver = props.getProperty("jdbcDriver");
			log.debug("jdbcUrl : "+jdbcUrl);
			log.debug("userId : "+userId);
			log.debug("password : "+password);
			log.debug("jdbcDriver : "+jdbcDriver);
			log.debug("############### Properties Load end");
			
		} catch (FileNotFoundException e) {
			throw new NonBizException("FileNotFoundException!!", e);
		} catch (IOException e) {
			throw new NonBizException("IOException!!", e);
		} finally {
			try {
				fin.close();
			} catch (IOException e) {
				throw new NonBizException("fin.close() 실패!!", e);
			}
		}
	}

	public static Configuration getInstance() {
		if(configuration == null) {
			configuration = new Configuration();
			log.debug("############### configuration singleton 생성!!");
		}
		return configuration;
	}
	public static Properties getProperties() {
		return props;
	}
	
	public String getProperties(String key) {
		String value = "";
		value = props.getProperty(key);
		return value;
	}
}
