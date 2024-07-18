package com.sistemarpg.sistemarpg.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemarpg.sistemarpg.models.Habilidade;
import com.sistemarpg.sistemarpg.models.HabilidadesPersonagem;
import com.sistemarpg.sistemarpg.models.Personagem;
import com.sistemarpg.sistemarpg.repositories.HabilidadeRepository;
import com.sistemarpg.sistemarpg.repositories.HabilidadesPersonagemRepository;
import com.sistemarpg.sistemarpg.repositories.PersonagemRepository;

@Service
public class HabilidadesPersonagemService {

    @Autowired
    private HabilidadesPersonagemRepository habilidadesPersonagemRepository;
    @Autowired
    private PersonagemRepository personagemRepository; // Assuming you have this repository
    @Autowired
    private HabilidadeRepository habilidadeRepository; // Assuming you have this repository

    public void salvarHabilidadesParaPersonagem(int personagemId, List<Integer> habilidadesIds) {
        habilidadesPersonagemRepository.deleteByPersonagem_Id(personagemId);

        Personagem personagem = personagemRepository.findById(personagemId).orElseThrow(() -> new RuntimeException("Personagem not found"));

        for (Integer habilidadeId : habilidadesIds) {
            Habilidade habilidade = habilidadeRepository.findById(habilidadeId).orElseThrow(() -> new RuntimeException("Habilidade not found"));

            HabilidadesPersonagem novaHabilidade = new HabilidadesPersonagem();
            novaHabilidade.setPersonagem(personagem);
            novaHabilidade.setHabilidade(habilidade);
            habilidadesPersonagemRepository.save(novaHabilidade);
        }
    }

    public List<HabilidadesPersonagem> buscarHabilidadesPorPersonagemId(int personagemId) {
        return habilidadesPersonagemRepository.findByPersonagemId(personagemId);
    }
}