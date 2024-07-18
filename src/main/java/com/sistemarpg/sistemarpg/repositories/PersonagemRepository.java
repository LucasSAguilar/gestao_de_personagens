package com.sistemarpg.sistemarpg.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.sistemarpg.sistemarpg.models.Personagem;

@Repository
public interface PersonagemRepository extends JpaRepository<Personagem, Integer> {
}
