package com.sistemarpg.sistemarpg.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sistemarpg.sistemarpg.models.Habilidade;
import com.sistemarpg.sistemarpg.models.Personagem;
import com.sistemarpg.sistemarpg.services.HabilidadeService;
import com.sistemarpg.sistemarpg.services.HabilidadesPersonagemService;
import com.sistemarpg.sistemarpg.services.PersonagemService;

@Controller
public class HabilidadesPersonagemController {

    @Autowired
    HabilidadeService habilidadeService;

    @Autowired
    PersonagemService personagemService;

    @Autowired
    HabilidadesPersonagemService habilidadesPersonagemService;

    @GetMapping("/personagens/{id}/habilidades")
    public String habilidades(@PathVariable("id") int id, Model model) {

        List<Habilidade> listaHabilidades = habilidadeService.buscarTodos();
        Personagem personagemEncontrado = personagemService.buscarPorId(id);
        model.addAttribute("listaHabilidades", listaHabilidades);
        model.addAttribute("personagemEditado", personagemEncontrado);
        return "habilidades_personagens/index";
    }

    @PostMapping("/personagens/{personagemId}/habilidades")
    public String salvarHabilidades(@PathVariable int personagemId, @RequestParam List<Integer> habilidades,
            RedirectAttributes redirectAttributes) {
        habilidadesPersonagemService.salvarHabilidadesParaPersonagem(personagemId, habilidades);
        redirectAttributes.addFlashAttribute("mensagemSucesso", "Habilidades atualizadas com sucesso!");
        return "redirect:/personagens";
    }

}
