package com.xdcr;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class Application {

	public static void main(String[] args) {
		Logger logger = Logger.getLogger(Application.class);
		SpringApplication.run(Application.class,args);
		//BasicFormAuthenticationFilter.setApplicationContext(applicationContext);
		logger.info("log4j------");

	}

}
