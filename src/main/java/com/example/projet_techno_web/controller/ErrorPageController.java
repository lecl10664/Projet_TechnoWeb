package com.example.projet_techno_web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorPageController {

    public ErrorPageController() {}


    @GetMapping("/error")
    public String showPage(){
        return "/index";
    }
}
