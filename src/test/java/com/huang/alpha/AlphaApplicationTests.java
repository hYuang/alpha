package com.huang.alpha;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootApplication
@EnableAutoConfiguration
@MapperScan(basePackages="com.huang.alpha.mapper")
public class AlphaApplicationTests {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(AlphaApplicationTests.class, args);
		System.out.println(context.isSingleton("alphaFactoryBean"));
		System.out.println("----------------");
		System.out.println(context.isSingleton("&alphaFactoryBean"));

	}

}

