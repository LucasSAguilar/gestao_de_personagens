package com.sistemarpg.sistemarpg.repositories;

import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemarpg.sistemarpg.models.Habilidade;

@Repository
public interface HabilidadeRepository extends JpaRepository<Habilidade, Integer> {
}
