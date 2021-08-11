package com.example.eduInter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication

@ComponentScan("com.example.ThreeTest")
@EnableSwagger2
public class EduInterApplication {


	public static void main(String[] args) {

		SpringApplication.run(EduInterApplication.class, args);
	}

}
