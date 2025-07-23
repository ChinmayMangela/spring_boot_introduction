package com.example.spring_boot_introduction.controllers

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloWorldController {

    @RequestMapping("/")
    fun hello(): String {
        return "Hello World!";
    }
}