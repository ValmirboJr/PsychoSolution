package org.example.psychosolution.repository;

import org.example.psychosolution.entity.Pacientes;
import org.springframework.data.domain.Limit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.lang.ScopedValue;
import java.util.Optional;
import java.util.UUID;

public interface PacientesRepository extends JpaRepository<Pacientes, Long> {

    Optional<Pacientes> findByEmail(String email);
    Optional<Pacientes> findById(UUID id);
    Optional<Pacientes> deleteById(UUID id);
    Optional<UserDetails>findPacientesByEmail(String email);
}
