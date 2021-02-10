package com.se.hackathon.helper.config;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    private final long MAX_AGE_SECS = 3600;
    @Value("#{'${storage.location}'}")
    String uploadRootLocation;

    @Autowired
    ResourceLoader resourceLoader;

    @SneakyThrows
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

//        Resource resource = resourceLoader.getResource("classpath:1.gif");
//        InputStream input = resource.getInputStream();
//        File file = resource.getFile();


        registry.addResourceHandler("/uploads/**")
                .addResourceLocations("file:uploadRootLocation/");

    }
}