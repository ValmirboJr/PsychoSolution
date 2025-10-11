USE psychosolution;

INSERT INTO psicologos (nome, crp, email, telefone, especialidade)
VALUES
('Ana Silva', 'CRP12345', 'ana@email.com', '11999999999', 'Clínica'),
('Carlos Souza', 'CRP67890', 'carlos@email.com', '11988888888', 'Infantil');

INSERT INTO pacientes (nome, data_nascimento, telefone, email, sexo)
VALUES
('João Pedro', '1990-05-12', '11977777777', 'joao@email.com', 'M'),
('Maria Clara', '1985-09-23', '11966666666', 'maria@email.com', 'F');

INSERT INTO consultas (id_psicologo, id_paciente, data_consulta, observacoes)
VALUES
(1, 1, '2025-10-15 14:00:00', 'Primeira consulta'),
(2, 2, '2025-10-16 10:00:00', 'Acompanhamento');
