package com.example.PosteduTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@SpringBootApplication
@RestController
public class PostTest {

    @RequestMapping(value = "/helloPost",method = RequestMethod.POST)
    public String HelloPost(@RequestParam(value = "dai",required = true)String name,@RequestParam(value = "18",required = false)String age){

        return "post success";
    }

    public static void main(String[] args) {
        SpringApplication.run(PostTest.class,args);
    }
}
