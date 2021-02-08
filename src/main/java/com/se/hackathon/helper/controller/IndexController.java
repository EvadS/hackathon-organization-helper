package com.se.hackathon.helper.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * Home redirection to swagger api documentation
 */
@ApiIgnore
@RestController
public class IndexController {

    @GetMapping(value = "/")
    public String index() {
        return "redirect:swagger-ui.html";
    }
}
