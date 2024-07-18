package com.sistemarpg.sistemarpg.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavegacaoController {

    @GetMapping("/")
    public String inicio() {
        return "inicio/index";
    }

}
