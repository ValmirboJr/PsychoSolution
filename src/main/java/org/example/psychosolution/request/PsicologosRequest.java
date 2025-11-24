package org.example.psychosolution.request;

import lombok.Builder;

@Builder
public record PsicologosRequest(String nome,
                                String email,
                                String telefone,
                                String crp,
                                String senha) {
}
