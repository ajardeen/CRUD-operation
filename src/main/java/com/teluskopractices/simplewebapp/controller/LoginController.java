package com.teluskopractices.simplewebapp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @RequestMapping("/login")
    public String login(){
        return "Login successfully";
    }

    @RequestMapping("/getdata")
    public String productData(){
        return"getdata";
    }

}
