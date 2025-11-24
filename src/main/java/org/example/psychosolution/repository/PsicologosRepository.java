package org.example.psychosolution.repository;

import org.example.psychosolution.entity.Psicologos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PsicologosRepository extends JpaRepository<Psicologos, UUID> {

    Optional<Psicologos> findByCrp(String crp);

}
