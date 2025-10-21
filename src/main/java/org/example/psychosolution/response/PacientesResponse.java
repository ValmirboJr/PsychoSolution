package org.example.psychosolution.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;

import java.time.LocalDate;
import java.util.UUID;

@Builder
public record PacientesResponse(UUID id,
                                String nome,
                                String cpf,
                                int idade,
                                String telefone,
                                String email,
                                @JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
                                LocalDate dataNascimento
                                ) {
}
