package com.sistemarpg.sistemarpg.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sistemarpg.sistemarpg.models.Habilidade;
import com.sistemarpg.sistemarpg.services.HabilidadeService;

@Controller
public class HabilidadeController {

    @Autowired
    HabilidadeService habilidadeService;

    @GetMapping("/habilidades")
    public String habilidades(Model model) {
        List<Habilidade> listaHabilidades = habilidadeService.buscarTodos();
        model.addAttribute("listaHabilidades", listaHabilidades);
        return "habilidades/index";
    }

    @GetMapping("/habilidades/nova")
    public String novaHabilidade() {
        return "nova_habilidade/index";
    }

    @PostMapping("/habilidade")
    public String salvarHabilidade(@ModelAttribute Habilidade habilidade) {
        habilidadeService.salvar(habilidade);
        return "redirect:/habilidades";
    }
}
