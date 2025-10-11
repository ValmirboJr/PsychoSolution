CREATE DATABASE psychosolution;
USE psychosolution;

CREATE TABLE usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    senha VARCHAR(255) NOT NULL,
    data_cadastro TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE pacientes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    idade INT,
    telefone VARCHAR(20),
    email VARCHAR(100)
);

CREATE TABLE psicologos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    crp VARCHAR(20) UNIQUE NOT NULL,
    email VARCHAR(100),
    telefone VARCHAR(20)
);

CREATE TABLE consultas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_psicologo INT,
    id_paciente INT,
    data_consulta DATETIME,
    observacoes TEXT,
    FOREIGN KEY (id_psicologo) REFERENCES psicologos(id),
    FOREIGN KEY (id_paciente) REFERENCES pacientes(id),
    FOREIGN KEY (id_psicologo) REFERENCES psicologos(id) ON DELETE CASCADE,
    FOREIGN KEY (id_paciente) REFERENCES pacientes(id) ON DELETE CASCADE
);