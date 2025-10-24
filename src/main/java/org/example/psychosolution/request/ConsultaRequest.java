package org.example.psychosolution.request;

import lombok.Builder;
import org.example.psychosolution.entity.Pacientes;

import java.time.LocalDateTime;

@Builder
public record ConsultaRequest(Pacientes paciente, LocalDateTime data,String status) {
}
