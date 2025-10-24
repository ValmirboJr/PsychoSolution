package org.example.psychosolution.response;

import lombok.Builder;
import org.example.psychosolution.entity.Pacientes;

import java.time.LocalDateTime;

@Builder
public record ConsultaResponse(Long id, Pacientes paciente, LocalDateTime data, String status) {
}
