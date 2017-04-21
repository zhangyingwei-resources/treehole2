package com.zhangyingwei.treehole;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("com.zhangyingwei.treehole")
@Configuration
public class TreeholeApplication {

	public static void main(String[] args) {
		SpringApplication.run(TreeholeApplication.class, args);
	}
}
