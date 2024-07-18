package com.sistemarpg.sistemarpg.services;
import com.sistemarpg.sistemarpg.models.Habilidade;
import com.sistemarpg.sistemarpg.repositories.HabilidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabilidadeService {

    @Autowired
    private HabilidadeRepository habilidadeRepository;

    public List<Habilidade> buscarTodos() {
        return habilidadeRepository.findAll();
    }

    public void salvar(Habilidade habilidade) {
        habilidadeRepository.save(habilidade);
    }
}