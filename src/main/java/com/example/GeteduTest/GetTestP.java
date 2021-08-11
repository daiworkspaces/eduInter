package com.example.GeteduTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@ComponentScan("com.example.GeteduTest")
@RestController
public class GetTestP {


    @RequestMapping(value = "/helloGet",method = RequestMethod.GET)
    public String HelloGet(){
        return "HelloGetSuccess";
    }

    //响应添加cookie
    @RequestMapping(value = "/helloGetCooke",method = RequestMethod.GET)
    public String HelloGetPar(HttpServletResponse res){
        Cookie cookie = new Cookie("name","dai");
        res.addCookie(cookie);
         return "helloGetSuccess cookie";
    }

    //请求添加cookie
    @RequestMapping(value = "/helloGetC",method = RequestMethod.GET)
    public String HelloGetPara(HttpServletRequest rqs){
        Cookie[] cookies = rqs.getCookies();
        for (Cookie coo:cookies){
            if (coo.getName().equals("name") && coo.getValue().contentEquals("dai"));
        }
        return "cookie success ";

    }

    @RequestMapping(value = "/helloParam",method = RequestMethod.GET)
    public String HelloGetParam(@RequestParam String name,@RequestParam String age ) {

        Map<String,String> map = new HashMap<>();
        map.put("name","dai");
        map.put("age","18");
        return map.toString();

    }

    @RequestMapping(value = "/helloParam001/{name}/{age}",method = RequestMethod.GET)
    public Map<String,String> HelloGetParam01(@PathVariable String name,@PathVariable String age){

        Map<String,String> map = new HashMap<>();
        map.put("name","dai");
        map.put("age","18");
        return map;

    }




    public static void main(String[] args) {
        SpringApplication.run(GetTestP.class,args);

    }
}
