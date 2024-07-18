package com.sistemarpg.sistemarpg.services;

import com.sistemarpg.sistemarpg.models.Personagem;
import com.sistemarpg.sistemarpg.repositories.PersonagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonagemService {

    @Autowired
    private PersonagemRepository personagemRepository;

    public List<Personagem> buscarTodos() {
        return personagemRepository.findAll();
    }

    public Personagem buscarPorId(Integer id) {
        return personagemRepository.findById(id).get();
    }

    public void salvar(Personagem personagem) {
        personagemRepository.save(personagem);
    }
}