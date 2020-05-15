package com.vega2k.myspringboot.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class MyRunner implements ApplicationRunner{
	private Logger logger = LoggerFactory.getLogger(MyRunner.class);
	
	
	@Value("${vega2k.name}")
	private String name;
	
	@Value("${vega2k.age}")
	private int age;

	@Value("${vega2k.fullName}")
	private String fullName;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		logger.debug("환경변수 Name : " + name);
		logger.debug("환경변수 Age : " + age);
		logger.info("환경변수 fullName :" + fullName);
	}
}
