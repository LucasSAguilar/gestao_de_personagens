package com.sistemarpg.sistemarpg.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sistemarpg.sistemarpg.models.Habilidade;
import com.sistemarpg.sistemarpg.models.HabilidadesPersonagem;
import com.sistemarpg.sistemarpg.models.Personagem;
import com.sistemarpg.sistemarpg.services.HabilidadeService;
import com.sistemarpg.sistemarpg.services.HabilidadesPersonagemService;
import com.sistemarpg.sistemarpg.services.PersonagemService;

@Controller()
public class PersonagemController {

    @Autowired
    private PersonagemService personagemService;
    @Autowired
    private HabilidadeService habilidadeService;
    @Autowired
    private HabilidadesPersonagemService habilidadePersonagemService;

    @GetMapping("/personagens")
    public String personagem(Model model) {
        List<Personagem> personagens = personagemService.buscarTodos();
        model.addAttribute("listaPersonagens", personagens);
        return "personagens/index";
    }

    @GetMapping("/personagens/novo")
    public String novoPersonagem(Model model) {
        List<Habilidade> habilidades = habilidadeService.buscarTodos();
        model.addAttribute("listaHabilidades", habilidades);
        return "novo_personagem/index";
    }

    @GetMapping("/personagens/{id}")
    public String verPersonagem(@PathVariable int id, Model model) {
        Personagem personagem = personagemService.buscarPorId(id);
        List<HabilidadesPersonagem> habilidadesIds = habilidadePersonagemService.buscarHabilidadesPorPersonagemId(id);

        List<Habilidade> habilidades = new ArrayList<>();

        for (HabilidadesPersonagem hp : habilidadesIds) {
            habilidades.add(hp.getHabilidade());
        }


        model.addAttribute("habilidades", habilidades);
        model.addAttribute("personagem", personagem);
        return "ver_personagem/index";
    }

    @PostMapping("/personagens")
    public String salvarPersonagem(@ModelAttribute Personagem personagem) {
        personagemService.salvar(personagem);
        return "redirect:/personagens";
    }

}
