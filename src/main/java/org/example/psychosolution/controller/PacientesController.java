package org.example.psychosolution.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.psychosolution.entity.Pacientes;
import org.example.psychosolution.mapper.PacientesMapper;
import org.example.psychosolution.request.PacientesRequest;
import org.example.psychosolution.response.PacientesResponse;
import org.example.psychosolution.service.PacientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/pacientes")
public class PacientesController {

    @Autowired
    private PacientesService pacientesService;

    @PostMapping("/save")
    public ResponseEntity<PacientesResponse>salvar(@RequestBody PacientesRequest request){
        Pacientes save = pacientesService.Registro(PacientesMapper.toPacientes(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(PacientesMapper.toPacientesResponse(save));
    }
    @GetMapping()
    public ResponseEntity<List<PacientesResponse>>listarPaciente(){
        return ResponseEntity.ok(pacientesService.ListarPacientes()
                .stream().map(PacientesMapper::toPacientesResponse).toList());
    }
    @GetMapping("/{id}")
    public ResponseEntity<PacientesResponse>listarPacientesPorID(@PathVariable UUID id){
        return pacientesService.BuscarPaciente(id)
                .map(pacientes -> ResponseEntity.ok(PacientesMapper.toPacientesResponse(pacientes)))
                .orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/deletar")
    public ResponseEntity<PacientesResponse>deletarPaciente(@PathVariable UUID id){
        pacientesService.apagarCadastro(id);
        return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PacientesResponse>AtualizarPaciente(@PathVariable UUID id, @RequestBody PacientesRequest request){
        return pacientesService.AlterarCadastro(id,PacientesMapper.toPacientes(request))
           .map(pacientes -> ResponseEntity.ok(PacientesMapper.toPacientesResponse(pacientes)))
            .orElse(ResponseEntity.notFound().build());
    }
}