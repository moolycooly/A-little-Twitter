package com.my.project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GreetingController {

    @GetMapping("/")
    public String greeting() {
        System.out.println("##1212");
        return "greeting";
    }
}
