package com.czj.interview;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.czj.interview.Dao.mapper")
public class InterviewApplication {

	public static void main(String[] args) {

		SpringApplication.run(InterviewApplication.class, args);
	}

}
