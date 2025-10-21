package org.example.psychosolution.service;

import org.example.psychosolution.entity.Pacientes;
import org.example.psychosolution.repository.PacientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PacientesService {

    @Autowired
    private PacientesRepository pacientesRepository;

    public Pacientes Registro(Pacientes pacientes) {
        if (pacientesRepository.findByEmail(pacientes.getEmail()).isPresent()) {
        throw new RuntimeException("Paciente ja existe");
        }
        //Adicionar Depois Encriptador de senha
        return pacientesRepository.save(pacientes);
    }
    public List<Pacientes> ListarPacientes(){
        return pacientesRepository.findAll();
    }

    public Optional<Pacientes> BuscarPaciente(UUID idunico){
        return pacientesRepository.findById(idunico);
    }

    public Optional<Pacientes> AlterarCadastro(Pacientes pacientes, UUID idunico){
        Optional<Pacientes> OptPacientes = pacientesRepository.findById(idunico);
        if (OptPacientes.isPresent()) {

            Pacientes paciente = OptPacientes.get();
            paciente.setEmail(pacientes.getEmail());
            paciente.setIdade(pacientes.getIdade());
            paciente.setNome(pacientes.getNome());
            paciente.setTelefone(pacientes.getTelefone());
            paciente.setSenha(pacientes.getSenha());
            pacientesRepository.save(paciente);
            return Optional.of(paciente);
        }
        return Optional.empty();
    }
    public void apagarCadastro(UUID idunico){
        pacientesRepository.deleteById(idunico);
    }
}
