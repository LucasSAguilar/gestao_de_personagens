package com.sistemarpg.sistemarpg.repositories;

import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemarpg.sistemarpg.models.Habilidade;
import com.sistemarpg.sistemarpg.models.HabilidadesPersonagem;

import jakarta.transaction.Transactional;

@Repository
public interface HabilidadesPersonagemRepository extends JpaRepository<HabilidadesPersonagem, Integer> {
    @Transactional
    void deleteByPersonagem_Id(Integer personagem_id);

    List<HabilidadesPersonagem> findByPersonagemId(int personagemId);

}