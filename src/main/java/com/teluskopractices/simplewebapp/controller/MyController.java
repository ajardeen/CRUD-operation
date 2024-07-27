package com.teluskopractices.simplewebapp.controller;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @RequestMapping("/")
    public String main(){
        return "Welcome to home page 13";
    }

    @RequestMapping("/newpage")
    public String branch(){
        return "New page";
    }


}
