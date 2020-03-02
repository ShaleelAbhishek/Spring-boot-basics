package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @RequestMapping(value = "/hello",method = RequestMethod.POST)
    public String greeting(){
        return "from post method";
    }

    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    public String greetings(){
        return "from get method";
    }
}
