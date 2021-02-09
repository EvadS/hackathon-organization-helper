package com.se.hackathon.helper.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/organiser")
public class OrganiserController {
    @GetMapping("/")
    public  String index(){
        return "organiser";
    }
}
