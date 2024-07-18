package com.sistemarpg.sistemarpg.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Personagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String classe;
    private String descricao;
    private String historia;
    private String atributos;

    public Personagem(String nome, String classe, String descricao, String historia, String atributos) {
        this.nome = nome;
        this.classe = classe;
        this.descricao = descricao;
        this.historia = historia;
        this.atributos = atributos;
    }

    public Personagem() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getClasse() {
        return this.classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getHistoria() {
        return this.historia;
    }

    public void setHistoria(String historia) {
        this.historia = historia;
    }

    public String getAtributos() {
        return this.atributos;
    }

    public void setAtributos(String atributos) {
        this.atributos = atributos;
    }



}
