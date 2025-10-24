CREATE DATABASE psychosolution;
USE psychosolution;




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