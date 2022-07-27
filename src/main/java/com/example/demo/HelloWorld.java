package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

    @RequestMapping("/")
    public String hello(){

        return "Hello, and welcome to the demo for maven hum logo ne pipeline bana li hai successfully auto deploy nahi hona chahiye ";
    }
}
