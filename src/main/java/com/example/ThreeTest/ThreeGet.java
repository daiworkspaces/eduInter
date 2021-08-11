package com.example.ThreeTest;

import io.swagger.annotations.Api;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.PanelUI;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@RestController
@Api(value = "/")
public class ThreeGet {

    //没有使用Get方法的
    @RequestMapping("/ThreeGet")
    public String Hello() {
        return "ThreeGetNotParam Success";
    }

    //使用Get方法
    @RequestMapping(value = "/ThreeGetMethod", method = RequestMethod.GET)
    public String Hello_01() {
        return "ThreeGetNotParam Get method Success";
    }

    //响应中添加cookie
    @RequestMapping(value = "/ThreeGetCookie", method = RequestMethod.GET)
    public String Hello_02(HttpServletResponse res) {
        Cookie coo = new Cookie("name", "18");
        res.addCookie(coo);

        return "ThreeGetNotParam Response Cookie Success" + "cookie name:" + coo.getName() + "   " + "cookie value:" + coo.getValue();
    }

    //请求中添加cookie
    @RequestMapping(value = "/ThreeGetCookie01", method = RequestMethod.GET)
    public String Hello_03(HttpServletRequest req) {
        Cookie[] cokies = req.getCookies();
        for (Cookie coo : cokies) {
            if (coo.getName().equals("name") || coo.getValue().contentEquals("18")) {

            }
        }
        return "ThreeGetNotParam Request Cookie Success";

    }


    //请求参数Get，参数不在链接上的。 ;
    @RequestMapping(value = "/ThreeGetMapParam",method = RequestMethod.GET)
    public String Hello_04(@RequestParam String name ,@RequestParam String age){
        Map<String,String>map = new HashMap<>();
        map.put("name","dai");
        map.put("age","18");

        return "ThreeGetParam not Cookies Success" +map.toString();
    }

    @RequestMapping(value = "/ThreeGetMapUri/{name}/{age}",method = RequestMethod.GET)
    public Map<String,String> Hello_05(){
        Map<String,String>map = new HashMap<>();
        map.put("name","dai");
        map.put("age","18");
        return map;

    }

    public static void main(String[] args) {
        SpringApplication.run(ThreeGet.class,args);
    }
}
