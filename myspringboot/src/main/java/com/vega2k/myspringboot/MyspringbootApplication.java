package com.vega2k.myspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//Spring Bean Container + Spring Bean Configuration 클래스를 Load
public class MyspringbootApplication {

	public static void main(String[] args) {
//		SpringApplication.run(MyspringbootApplication.class, args);
		//Application Type 변경
		SpringApplication application = new SpringApplication(MyspringbootApplication.class);

		//Default 설정
		application.setWebApplicationType(WebApplicationType.SERVLET);
		
		//NONE으로 설정하면 웹 어플리케이션이 아님.
//		application.setWebApplicationType(WebApplicationType.NONE);
		
		application.run(args);
	}

}
