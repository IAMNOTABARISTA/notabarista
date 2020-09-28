package com.helloworld.helloworld;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppConfig {
    @RequestMapping("")
    public String helloWorld(){
        return "Hello World";
    }
}
