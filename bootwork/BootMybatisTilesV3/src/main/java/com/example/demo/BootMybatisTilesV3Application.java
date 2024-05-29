package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"controller.*","*.member", "data.*", "tiles.config", "com.example.demo", "naver.cloud"}) //{}안에서는 ','로 여러개를 줄 수 있다.
@MapperScan("data.mapper")
public class BootMybatisTilesV3Application {

	public static void main(String[] args) {
		SpringApplication.run(BootMybatisTilesV3Application.class, args);
	}
}
