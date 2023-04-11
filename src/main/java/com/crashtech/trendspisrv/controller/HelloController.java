package com.crashtech.trendspisrv.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {
 
    @Autowired
    private MessageSource messageSource;
 
    @GetMapping("/{name}")
    public String sayHello(@PathVariable String name, Locale locale) {
        Object[] params = { name };
        return messageSource.getMessage("hello.message", params, locale);
    }
}

