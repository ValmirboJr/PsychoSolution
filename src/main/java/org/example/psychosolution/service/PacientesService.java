package org.example.psychosolution.service;

import org.example.psychosolution.entity.Consulta;
import org.example.psychosolution.entity.Pacientes;
import org.example.psychosolution.repository.ConsultaRepository;
import org.example.psychosolution.repository.PacientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PacientesService {

    @Autowired
    private PacientesRepository pacientesRepository;

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Pacientes Registro(Pacientes pacientes) {
        if (pacientesRepository.findByEmail(pacientes.getEmail()).isPresent()) {
            throw new RuntimeException("Paciente ja existe");
        }
        pacientes.setSenha(passwordEncoder.encode(pacientes.getSenha()));
        return pacientesRepository.save(pacientes);
    }

    public Pacientes login(Pacientes pacientes){
   Pacientes pacienteEncontrado =  pacientesRepository.findByEmail(pacientes.getEmail()).orElseThrow(() -> new RuntimeException("Pacientes no encontrado"));
    if (!passwordEncoder.matches(pacientes.getSenha(), pacientes.getSenha() )) {
        throw new RuntimeException("Senha Incorreta");
    }
    return pacienteEncontrado;
    }

    public List<Pacientes> ListarPacientes() {
        return pacientesRepository.findAll();
    }

    public Optional<Pacientes> BuscarPaciente(UUID idunico) {
        return pacientesRepository.findById(idunico);
    }

    public Optional<Pacientes> AlterarCadastro(UUID idunico, Pacientes pacientes) {
        Optional<Pacientes> OptPacientes = pacientesRepository.findById(idunico);
        if (OptPacientes.isPresent()) {

            Pacientes paciente = OptPacientes.get();
            paciente.setEmail(pacientes.getEmail());
            paciente.setIdade(pacientes.getIdade());
            paciente.setNome(pacientes.getNome());
            paciente.setTelefone(pacientes.getTelefone());
            paciente.setCpf(pacientes.getCpf());
            paciente.setDataNascimento(pacientes.getDataNascimento());
            paciente.setSenha(pacientes.getSenha());
            pacientesRepository.save(paciente);
            return Optional.of(paciente);
        }
        return Optional.empty();
    }

    public void apagarCadastro(UUID idunico) {
        pacientesRepository.deleteById(idunico);
    }

    public List<Consulta> consultasPaciente(UUID idPaciente) {
        if (pacientesRepository.findById(idPaciente).isEmpty()) {
            throw new RuntimeException("Paciente não encontrado");
        }
        return consultaRepository.findByPacienteId(idPaciente);
    }
}
