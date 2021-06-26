package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication
@EnableOpenApi
public class GroovyPracticeApplication {


    public static void main(String[] args) {
        SpringApplication.run(GroovyPracticeApplication.class, args);
    }

}
