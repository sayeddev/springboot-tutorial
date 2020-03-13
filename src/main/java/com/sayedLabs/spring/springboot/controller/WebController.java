package com.sayedLabs.spring.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {


    @GetMapping(value = "/index")
    public String index() {
        return "index";
    }

    @GetMapping(value = "/locale")
    public String locale(){
        return "locale";
    }
}
