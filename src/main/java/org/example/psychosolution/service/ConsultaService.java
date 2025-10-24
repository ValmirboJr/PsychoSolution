package org.example.psychosolution.service;

import org.example.psychosolution.entity.Consulta;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.example.psychosolution.repository.ConsultaRepository;


@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;


    public Consulta agendarConsulta(Consulta consulta){
        consulta.setStatus("AGENDADA");
        return consultaRepository.save(consulta);
    }

    public void cancelarConsulta(Long consultaId){
        if (consultaRepository.existsById(consultaId)) {
            consultaRepository.deleteById(consultaId);
        }
    }

    public List<Consulta> listarConsultas(){
        return consultaRepository.findAll();
    }

}
