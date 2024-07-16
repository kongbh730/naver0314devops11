package com.example.bootjpareact;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"bit.*.*","naver.storage","com.example.bootjpareact"})
@EntityScan({"bit.data.*"})
@EnableJpaRepositories({"bit.repository.*"})
public class BootJpaReactApplication
{
    public static void main(String[] args) {
        SpringApplication.run(BootJpaReactApplication.class, args);
    }

}
