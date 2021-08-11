package com.example.ThreeTest;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class ThreePost {

    //post参数的请求
    @RequestMapping(value = "/ThreePost01",method = RequestMethod.POST)
    public String ThreePost_01(@RequestParam(value = "name",required = true)String name,@RequestParam(value = "age",required = true)String age ){
        if (name.equals("dai")&&age.contentEquals("18")){
            return "The parameters are correct";
        }
       return "/ThreePost request Success";
    }

    //post参数的请求，请求头添加token

    @RequestMapping(value = "/ThreePost02",method = RequestMethod.POST)
    public String ThreePost_02(@RequestHeader(value = "token")String token,@RequestParam(value = "name")String name ,@RequestParam(value = "age")String arg){

        return "Three post request Success"+token;
    }

    //post参数的请求，body参数类型

    @RequestMapping(value = "/ThreePost03",method = RequestMethod.POST)
    public String ThreePost_03(@RequestBody User user){
        user.SetId(2);
        user.setName("dai");
        return "body";
    }
    

    public static void main(String[] args) {
        SpringApplication.run(ThreePost.class,args);

    }
}
