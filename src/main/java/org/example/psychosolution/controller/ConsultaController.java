package org.example.psychosolution.controller;

import org.example.psychosolution.entity.Consulta;
import org.example.psychosolution.mapper.ConsultaMapper;
import org.example.psychosolution.request.ConsultaRequest;
import org.example.psychosolution.response.ConsultaResponse;
import org.example.psychosolution.service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;

    @GetMapping()
    public ResponseEntity<List<ConsultaResponse>> ListarConsultas(){
        return ResponseEntity.ok(consultaService.listarConsultas()
                .stream().map(ConsultaMapper::toConsultaResponse).toList());
    }
    @PostMapping("/save")
    public ResponseEntity<ConsultaResponse> SalvarConsulta(@RequestBody ConsultaRequest request){
        Consulta save = consultaService.agendarConsulta(ConsultaMapper.toConsulta(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(ConsultaMapper.toConsultaResponse(save));
    }
    @DeleteMapping("{id}")
    public ResponseEntity<ConsultaResponse> ExcluirConsulta(@PathVariable Long id){
        consultaService.cancelarConsulta(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(ConsultaMapper.toConsultaResponse(null));
    }
}
