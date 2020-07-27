package com.example.springwebservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SpringWebserviceApplication {
	public static final String APPLICATION_LOCATIONS = "spring.config.location=" + "classpath:application.yml,"
			+ "C:/Users/user/app/config/springboot-webservice/real-application.yml," // for window
			+ "/Users/hc/app/config/springboot-webservice/real-application.yml," // for mac
			+ "/home/ec2-user/app/config/springboot-webservice/real-application.yml"; // for ec2

	public static void main(String[] args) {
		new SpringApplicationBuilder(SpringWebserviceApplication.class).properties(APPLICATION_LOCATIONS).run(args);
		// SpringApplication.run(SpringWebserviceApplication.class, args);
	}

}
