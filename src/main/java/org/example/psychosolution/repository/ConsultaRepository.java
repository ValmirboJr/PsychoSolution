package org.example.psychosolution.repository;

import org.example.psychosolution.entity.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;


public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

    List<Consulta> findByPacienteId(UUID idPaciente);
}
