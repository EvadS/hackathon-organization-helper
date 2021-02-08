package com.se.hackathon.helper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HackathonOrganizationHelperApplication {

    public static void main(String[] args) {
        System.out.println("Gradle command line arguments example");
        for (String arg : args) {
            System.out.println("Got argument [" + arg + "]");
        }

        SpringApplication.run(HackathonOrganizationHelperApplication.class, args);
    }

}
