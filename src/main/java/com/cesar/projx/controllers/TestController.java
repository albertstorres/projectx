package com.cesar.projx.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/teste")
public class TestController {

    @GetMapping()
    public String teste() {
        return new String("Servidor rodando.");
    }
    

}
