package org.example.psychosolution.response;

import lombok.Builder;

import java.util.UUID;

@Builder
public record PsicologosResponse(UUID id, String nome, String email, String telefone, String crp) {
}
