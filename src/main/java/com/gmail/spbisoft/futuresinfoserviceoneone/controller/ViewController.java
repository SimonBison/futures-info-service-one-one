package com.gmail.spbisoft.futuresinfoserviceoneone.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {
    @GetMapping(value="/")
    public String homepage(){
        return "index";
    }
}