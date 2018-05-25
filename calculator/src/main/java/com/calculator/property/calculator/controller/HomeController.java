package com.calculator.property.calculator.controller;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@org.springframework.stereotype.Controller
public class HomeController {


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(){
        return "index";
    }

}
