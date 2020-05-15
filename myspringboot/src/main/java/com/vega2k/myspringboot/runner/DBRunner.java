package com.vega2k.myspringboot.runner;

import java.sql.Connection;
import java.sql.DatabaseMetaData;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class DBRunner implements ApplicationRunner{
	@Autowired
	DataSource dataSource;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println(dataSource.getClass().getName());
		Connection connection = dataSource.getConnection();
		DatabaseMetaData metaData = connection.getMetaData();
		System.out.println(metaData.getURL());
		System.out.println(metaData.getUserName());
	}
}
