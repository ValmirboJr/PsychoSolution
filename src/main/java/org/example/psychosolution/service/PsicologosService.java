package org.example.psychosolution.service;

import org.example.psychosolution.entity.Psicologos;
import org.example.psychosolution.repository.PsicologosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PsicologosService {

    @Autowired
    private PsicologosRepository psicologosRepository;

    public Psicologos findPsicologosById(UUID id) {
        return psicologosRepository.findById(id).orElse(null);
    }
    public Psicologos salvar(Psicologos psicologos) {
        if (psicologosRepository.findByCrp(psicologos.getCrp()).isPresent()) {
            throw new RuntimeException("CRP já Cadastrado");
        }
        return psicologosRepository.save(psicologos);
    }
}
