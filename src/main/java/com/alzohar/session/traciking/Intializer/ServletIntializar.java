package com.alzohar.session.traciking.Intializer;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.alzohar.session.traciking.SessionTrackingApplication;

public class ServletIntializar extends SpringBootServletInitializer{

	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SessionTrackingApplication.class);
		
	}
}
