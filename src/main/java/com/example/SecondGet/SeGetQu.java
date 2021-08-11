package com.example.SecondGet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SpringBootApplication
@RestController
@ComponentScan("com.example.SecondGet")
public class SeGetQu {

    @RequestMapping("/secondHell")
    public String HelloWorld(){
        return "firstHelloWorld success";
    }

    @RequestMapping(value = "/secondHell01",method = RequestMethod.GET)
    public String HelloWorld01(HttpServletResponse response){
        Cookie cookie = new Cookie("name","dai");
        response.addCookie(cookie);
        return "firstHelloWorld01 success";
    }

    @RequestMapping(value = "/secondHell02",method = RequestMethod.GET)
    public String HelloWorld02(HttpServletRequest request){
        //Cookie cookie = new Cookie("name","dai");
        Cookie[] coo = request.getCookies();
        for (Cookie co:coo){
            if (co.getName().equals("name")&& co.getValue().contentEquals("dai"));
        }
        return "firstHelloWorld01 success";
    }


    public static void main(String[] args) {
        SpringApplication.run(SeGetQu.class,args);
    }
}
