package br.com.ifg.contolefinanca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class HelloController {

    @GetMapping
    String hello(){
        return "Olá mundo!";
    }
}
