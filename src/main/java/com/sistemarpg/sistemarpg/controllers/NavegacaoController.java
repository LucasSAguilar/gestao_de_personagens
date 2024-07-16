package com.sistemarpg.sistemarpg.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavegacaoController {

    @GetMapping("/")
    public String inicio() {
        return "inicio/index";
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard/index";
    }

    @GetMapping("/personagens")
    public String personagens() {
        return "personagens/index";
    }

    @GetMapping("/personagens/novo")
    public String novoPersonagem() {
        return "novo_personagem/index";
    }

    @GetMapping("/habilidades")
    public String habilidades() {
        return "habilidades/index";
    }

    @GetMapping("/habilidades/nova")
    public String novaHabilidade() {
        return "nova_habilidade/index";
    }
    @GetMapping("/personagem/01")
    public String verPersonagem() {
        return "ver_personagem/index";
    }

}
