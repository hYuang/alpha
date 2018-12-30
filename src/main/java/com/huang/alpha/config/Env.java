package com.huang.alpha.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Configuration
@PropertySource(value = {"application.properties"})
@Component
public class Env {

	@Autowired
	private Environment env;
	
	public String getConfiguration(String key) {
		 return env.getProperty(key);
	}
}
