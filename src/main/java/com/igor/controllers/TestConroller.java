package com.igor.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class TestConroller {

    private static Logger logger = LoggerFactory.getLogger(TestConroller.class);

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("menu")
    public String menu(){
        return "menu";
    }

}
