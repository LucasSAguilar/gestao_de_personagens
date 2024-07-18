DROP DATABASE sistema_rpg;
CREATE DATABASE SISTEMA_RPG;
USE SISTEMA_RPG;
CREATE TABLE personagem (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    classe VARCHAR(255) NOT NULL,
    descricao TEXT NOT NULL,
    historia TEXT NOT NULL,
    atributos TEXT NOT NULL
);

CREATE TABLE habilidade (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    descricao TEXT NOT NULL
);

CREATE TABLE habilidades_para_personagens (
	id INT AUTO_INCREMENT PRIMARY KEY,
    personagem_id INT NOT NULL,
    habilidade_id INT NOT NULL,
    FOREIGN KEY (personagem_id) REFERENCES personagem(id),
    FOREIGN KEY (habilidade_id) REFERENCES habilidade(id)
);

-- Inserir dados de teste na tabela personagem
INSERT INTO personagem (nome, classe, descricao, historia, atributos) VALUES
('Arthas', 'Guerreiro', 'Um guerreiro destemido', 'Arthas foi um herói lendário.', 'Força: 90, Agilidade: 70, Inteligência: 60'),
('Luna', 'Arqueira', 'Uma arqueira ágil', 'Luna é conhecida por sua precisão.', 'Força: 60, Agilidade: 90, Inteligência: 70');

-- Inserir dados de teste na tabela habilidade
INSERT INTO habilidade (nome, descricao) VALUES
('Espada Flamejante', 'Uma espada que emite chamas.'),
('Tiro Rápido', 'Dispara flechas rapidamente.'),
('Camuflagem', 'Permite que o usuário se misture com o ambiente.');

-- Inserir dados de teste na tabela habilidades_para_personagens
INSERT INTO habilidades_para_personagens (personagem_id, habilidade_id) VALUES
(1, 1),  -- Arthas tem a habilidade Espada Flamejante
(2, 2),  -- Luna tem a habilidade Tiro Rápido
(2, 3);  -- Luna também tem a habilidade Camuflagem