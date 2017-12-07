package com.xdcr.framework.core.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class WebConfig extends WebMvcConfigurationSupport {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
	    registry.addResourceHandler("/lib/**").addResourceLocations("classpath:/lib/");
	    registry.addResourceHandler("/**").addResourceLocations("classpath:/static/")
	    			.addResourceLocations("classpath:/templates/");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
