package com.sistemarpg.sistemarpg.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "habilidades_para_personagens")
public class HabilidadesPersonagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "personagem_id") // Isso deve corresponder ao nome da coluna no banco de dados.
    private Personagem personagem;
    @ManyToOne
    @JoinColumn(name = "habilidade_id") // Isso deve corresponder ao nome da coluna no banco de dados.
    private Habilidade habilidade;

    public HabilidadesPersonagem(Personagem personagem_id, Habilidade habilidade_id) {
        this.personagem = personagem_id;
        this.habilidade = habilidade_id;
    }

    public HabilidadesPersonagem() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Personagem getPersonagem() {
        return this.personagem;
    }

    public void setPersonagem(Personagem personagem) {
        this.personagem = personagem;
    }

    public Habilidade getHabilidade() {
        return this.habilidade;
    }

    public void setHabilidade(Habilidade habilidade) {
        this.habilidade = habilidade;
    }

}
