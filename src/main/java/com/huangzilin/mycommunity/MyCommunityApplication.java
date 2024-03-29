package com.huangzilin.mycommunity;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan
public class MyCommunityApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyCommunityApplication.class, args);
	}

}
